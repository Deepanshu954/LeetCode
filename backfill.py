import json
import os
import re
import shutil
import subprocess
import time
from datetime import datetime, timezone

import requests
from dotenv import load_dotenv

load_dotenv()

SESSION = os.getenv("LEETCODE_SESSION")
CSRF = os.getenv("CSRF_TOKEN")
REPO_PATH = os.getenv("GITHUB_REPO_PATH") or os.getcwd()

FAILURES_JSON = "backfill_failures.json"
FAILURES_MD = "backfill_failures.md"
QUESTION_DIR_RE = re.compile(r"^\d{4}-.+")

HEADERS = {
    "cookie": f"LEETCODE_SESSION={SESSION}; csrftoken={CSRF}",
    "x-csrftoken": CSRF,
    "content-type": "application/json",
    "referer": "https://leetcode.com",
    "user-agent": "Mozilla/5.0",
}

EXTENSION_MAP = {
    "cpp": "cpp",
    "java": "java",
    "python": "py",
    "python3": "py",
    "c": "c",
    "javascript": "js",
    "typescript": "ts",
    "go": "go",
    "rust": "rs",
    "kotlin": "kt",
    "swift": "swift",
    "scala": "scala",
}

STATUS_ICONS = {
    "Accepted": "✅",
    "Wrong Answer": "❌",
    "Time Limit Exceeded": "⏱️",
    "Runtime Error": "💥",
    "Compile Error": "🛠️",
    "Memory Limit Exceeded": "🧠",
    "Output Limit Exceeded": "📤",
    "Presentation Error": "📝",
    "Internal Error": "🚨",
}


def api_post(query):
    response = requests.post(
        "https://leetcode.com/graphql",
        json=query,
        headers=HEADERS,
        timeout=30,
    )
    response.raise_for_status()
    return response.json()


def git(args, env=None):
    return subprocess.run(
        ["git"] + args,
        cwd=REPO_PATH,
        capture_output=True,
        text=True,
        env={**os.environ, **(env or {})},
    )


def git_require(args, env=None):
    result = git(args, env=env)
    if result.returncode != 0:
        raise RuntimeError(result.stderr.strip() or result.stdout.strip() or f"git {' '.join(args)} failed")
    return result


def git_commit_with_date(message, timestamp_unix, allow_empty=False):
    dt = datetime.fromtimestamp(timestamp_unix, tz=timezone.utc)
    iso = dt.strftime("%Y-%m-%dT%H:%M:%S+00:00")
    env = {
        "GIT_AUTHOR_DATE": iso,
        "GIT_COMMITTER_DATE": iso,
    }
    args = ["commit", "-m", message]
    if allow_empty:
        args.append("--allow-empty")
    git_require(args, env=env)


def ensure_env():
    missing = []
    if not SESSION:
        missing.append("LEETCODE_SESSION")
    if not CSRF:
        missing.append("CSRF_TOKEN")
    if missing:
        raise RuntimeError(f"Missing required env vars in .env: {', '.join(missing)}")


def ensure_clean_worktree():
    status = git_require(["status", "--porcelain"]).stdout.strip()
    if status:
        raise RuntimeError("Git working tree is not clean. Commit/stash changes before running backfill.py.")


def get_current_branch():
    return git_require(["branch", "--show-current"]).stdout.strip() or "master"


def create_backup_branch_name():
    stamp = datetime.now().strftime("%Y%m%d-%H%M%S")
    return f"backup/pre-backfill-{stamp}"


def prepare_history_rewrite():
    original_branch = get_current_branch()
    backup_branch = create_backup_branch_name()

    print(f"▶ Creating backup branch: {backup_branch}")
    git_require(["branch", backup_branch])

    print("▶ Creating orphan replay branch...")
    git_require(["checkout", "--orphan", "backfill-replay"])
    git_require(["rm", "-r", "--cached", "--ignore-unmatch", "."])

    clear_generated_content()
    return original_branch, backup_branch


def clear_generated_content():
    for name in os.listdir(REPO_PATH):
        path = os.path.join(REPO_PATH, name)
        if name in {".git", ".env", ".venv"}:
            continue
        if QUESTION_DIR_RE.match(name) and os.path.isdir(path):
            shutil.rmtree(path)
            continue
        if name in {"README.md", FAILURES_JSON, FAILURES_MD} and os.path.exists(path):
            os.remove(path)
            continue
        if name == "__pycache__" and os.path.isdir(path):
            shutil.rmtree(path)


def finalize_rewritten_branch(original_branch):
    git_require(["branch", "-M", original_branch])


def get_submissions(offset=0, limit=20):
    query = {
        "query": """
        query submissionList($offset: Int!, $limit: Int!, $lastKey: String) {
            submissionList(offset: $offset, limit: $limit, lastKey: $lastKey) {
                lastKey
                hasNext
                submissions {
                    id
                    title
                    titleSlug
                    statusDisplay
                    lang
                    timestamp
                }
            }
        }
        """,
        "variables": {"offset": offset, "limit": limit, "lastKey": None},
    }
    return api_post(query)


def get_submission_detail(submission_id):
    query = {
        "query": """
        query submissionDetails($submissionId: Int!) {
            submissionDetails(submissionId: $submissionId) {
                code
                lang { name verboseName }
                question {
                    questionId
                    title
                    titleSlug
                    difficulty
                    topicTags { name }
                    content
                }
            }
        }
        """,
        "variables": {"submissionId": int(submission_id)},
    }
    return api_post(query)


def clean_html(content):
    if not content:
        return ""

    text = re.sub(r"<[^>]+>", "", content)
    text = (
        text.replace("&lt;", "<")
        .replace("&gt;", ">")
        .replace("&amp;", "&")
        .replace("&quot;", '"')
        .replace("&#39;", "'")
        .replace("&nbsp;", " ")
    )
    return re.sub(r"\n{3,}", "\n\n", text).strip()


def generate_problem_readme(question_id, title, slug, difficulty, topic_tags, content):
    badge = {"Easy": "🟢 Easy", "Medium": "🟡 Medium", "Hard": "🔴 Hard"}.get(difficulty, difficulty)
    tags = ", ".join([t["name"] for t in topic_tags]) if topic_tags else "N/A"
    body = clean_html(content)

    return (
        f"# [{question_id}. {title}](https://leetcode.com/problems/{slug}/)\n\n"
        f"**Difficulty:** {badge}  \n"
        f"**Topics:** {tags}\n\n"
        "---\n\n"
        "## Problem\n\n"
        f"{body}\n"
    )


def generate_main_readme(problems, total_submissions, failed_submissions):
    easy = [p for p in problems if p["difficulty"] == "Easy"]
    medium = [p for p in problems if p["difficulty"] == "Medium"]
    hard = [p for p in problems if p["difficulty"] == "Hard"]

    topic_map = {}
    for problem in problems:
        for tag in problem["topic_tags"]:
            topic_map.setdefault(tag["name"], 0)
            topic_map[tag["name"]] += 1

    topic_rows = ""
    for topic, count in sorted(topic_map.items(), key=lambda item: (-item[1], item[0])):
        topic_rows += f"| {topic} | {count} |\n"

    problems_sorted = sorted(problems, key=lambda item: int(item["question_id"]))
    problem_rows = ""
    for problem in problems_sorted:
        icon = {"Easy": "🟢", "Medium": "🟡", "Hard": "🔴"}.get(problem["difficulty"], "⚪")
        tags = ", ".join([tag["name"] for tag in problem["topic_tags"][:2]])
        folder = f"{problem['question_id'].zfill(4)}-{problem['slug']}"
        problem_rows += f"| [{problem['question_id']}. {problem['title']}](./{folder}/) | {icon} {problem['difficulty']} | {tags} |\n"

    structure_block = (
        "```\n"
        "LeetCode/\n"
        "├── 0001-two-sum/\n"
        "│   ├── 0001-two-sum.java\n"
        "│   └── README.md\n"
        "├── 0200-number-of-islands/\n"
        "│   ├── 0200-number-of-islands.java\n"
        "│   └── README.md\n"
        "└── ...\n"
        "```"
    )

    sections = [
        '<div align="center">\n',
        "# 🧠 LeetCode Submission History\n",
        "### Deepanshu Chauhan · Complete LeetCode Replay\n",
        "[![LeetCode](https://img.shields.io/badge/LeetCode-Deepanshu954-FFA116?style=for-the-badge&logo=leetcode&logoColor=white)](https://leetcode.com/u/deepanshu954/)",
        "[![GitHub](https://img.shields.io/badge/GitHub-Deepanshu954-181717?style=for-the-badge&logo=github&logoColor=white)](https://github.com/Deepanshu954)",
        "[![Language](https://img.shields.io/badge/Primary%20Language-Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.java.com)\n",
        "</div>\n",
        "---\n",
        "## 📊 Replay Stats\n",
        "| Category | Count |",
        "|----------|-------|",
        f"| 🧾 Total Submission Commits | {total_submissions} |",
        f"| ✅ Latest Problem Snapshots | {len(problems)} |",
        f"| 🟢 Easy | {len(easy)} |",
        f"| 🟡 Medium | {len(medium)} |",
        f"| 🔴 Hard | {len(hard)} |",
        f"| ⚠️ Failed Retrievals | {failed_submissions} |\n",
        f"> Every retrieved submission is replayed as its own git commit. Failed submissions are listed in `./{FAILURES_MD}`.\n",
        "---\n",
        "## 🗂️ Topics Covered\n",
        "| Topic | Problems |",
        "|-------|----------|",
        topic_rows,
        "---\n",
        "## 📋 Latest Snapshot Per Problem\n",
        "| Problem | Difficulty | Topics |",
        "|---------|------------|--------|",
        problem_rows,
        "---\n",
        "## 🏗️ Structure\n",
        structure_block + "\n",
        "Each folder contains:\n",
        "- the latest code snapshot encountered during replay",
        "- a `README.md` with the problem statement\n",
        "---\n",
        '<div align="center">',
        "<sub>Backfilled from full LeetCode submission history with exact replay timestamps</sub>",
        "</div>\n",
    ]

    return "\n".join(sections)


def utc_string(timestamp_unix):
    return datetime.fromtimestamp(int(timestamp_unix), tz=timezone.utc).strftime("%Y-%m-%d %H:%M:%S UTC")


def status_icon(status_display):
    return STATUS_ICONS.get(status_display, "⚪")


def commit_message(submission):
    icon = status_icon(submission["status_display"])
    return (
        f"{icon} {submission['question_id']}. {submission['title']} | "
        f"{submission['status_display']} | sub:{submission['submission_id']}"
    )


def remove_old_solution_files(folder, folder_name, keep_ext):
    for ext in set(EXTENSION_MAP.values()):
        path = os.path.join(folder, f"{folder_name}.{ext}")
        if ext != keep_ext and os.path.exists(path):
            os.remove(path)


def save_submission_snapshot(submission):
    ext = EXTENSION_MAP.get(submission["lang"], "txt")
    folder_name = f"{submission['question_id'].zfill(4)}-{submission['slug']}"
    folder = os.path.join(REPO_PATH, folder_name)
    os.makedirs(folder, exist_ok=True)

    remove_old_solution_files(folder, folder_name, ext)

    solution_path = os.path.join(folder, f"{folder_name}.{ext}")
    readme_path = os.path.join(folder, "README.md")

    with open(solution_path, "w", encoding="utf-8") as fh:
        fh.write(submission["code"])

    with open(readme_path, "w", encoding="utf-8") as fh:
        fh.write(
            generate_problem_readme(
                submission["question_id"],
                submission["title"],
                submission["slug"],
                submission["difficulty"],
                submission["topic_tags"],
                submission["content"],
            )
        )

    return folder_name, ext


def write_failure_reports(failures):
    json_path = os.path.join(REPO_PATH, FAILURES_JSON)
    md_path = os.path.join(REPO_PATH, FAILURES_MD)

    payload = {
        "generated_at_utc": datetime.now(tz=timezone.utc).strftime("%Y-%m-%dT%H:%M:%SZ"),
        "failed_submission_count": len(failures),
        "failures": failures,
    }

    with open(json_path, "w", encoding="utf-8") as fh:
        json.dump(payload, fh, indent=2)

    grouped = {}
    for item in failures:
        key = f"{item['title']} ({item['slug']})"
        grouped.setdefault(key, []).append(item)

    lines = [
        "# Backfill Failures",
        "",
        f"Total failed submissions: **{len(failures)}**",
        "",
    ]

    if not failures:
        lines.append("No failures.")
    else:
        for key in sorted(grouped):
            lines.append(f"## {key}")
            lines.append("")
            for item in grouped[key]:
                lines.append(
                    "- "
                    f"submission `{item['submission_id']}` | "
                    f"status `{item['status_display']}` | "
                    f"listed lang `{item['listed_lang']}` | "
                    f"{item['timestamp_utc']} | "
                    f"reason: {item['reason']}"
                )
            lines.append("")

    with open(md_path, "w", encoding="utf-8") as fh:
        fh.write("\n".join(lines).rstrip() + "\n")


def fetch_all_submissions():
    all_submissions = []
    offset = 0

    print("▶ Fetching all submissions...\n")

    while True:
        data = get_submissions(offset=offset, limit=20)

        try:
            submission_list = data["data"]["submissionList"]
            submissions = submission_list["submissions"]
            has_next = submission_list["hasNext"]
        except (KeyError, TypeError) as exc:
            raise RuntimeError("Failed to fetch submission list. Check LEETCODE_SESSION / CSRF_TOKEN.") from exc

        all_submissions.extend(submissions)
        print(f"  Scanned {offset + len(submissions):>4} submissions → {len(all_submissions)} total")

        if not has_next:
            break

        offset += 20
        time.sleep(0.35)

    all_submissions.sort(key=lambda item: (int(item["timestamp"]), int(item["id"])))
    return all_submissions


def fetch_submission_payloads(all_submissions):
    replayable = []
    failures = []

    print("\n▶ Fetching submission details...\n")

    total = len(all_submissions)
    for index, sub in enumerate(all_submissions, 1):
        timestamp = int(sub["timestamp"])
        print(
            f"[{index:>4}/{total}] {sub['title']} | {sub['statusDisplay']} | "
            f"sub:{sub['id']} | {utc_string(timestamp)}"
        )

        try:
            detail = get_submission_detail(sub["id"])
            submission_details = detail["data"]["submissionDetails"]

            if not submission_details:
                failures.append(
                    {
                        "submission_id": sub["id"],
                        "title": sub["title"],
                        "slug": sub["titleSlug"],
                        "status_display": sub["statusDisplay"],
                        "listed_lang": sub["lang"],
                        "timestamp": timestamp,
                        "timestamp_utc": utc_string(timestamp),
                        "reason": "No detail returned",
                    }
                )
                print("  [FAIL] No detail returned")
                continue

            question = submission_details["question"]
            replayable.append(
                {
                    "submission_id": str(sub["id"]),
                    "timestamp": timestamp,
                    "timestamp_utc": utc_string(timestamp),
                    "title": sub["title"],
                    "slug": sub["titleSlug"],
                    "status_display": sub["statusDisplay"],
                    "listed_lang": sub["lang"],
                    "lang": submission_details["lang"]["name"],
                    "code": submission_details["code"] or "",
                    "question_id": question["questionId"],
                    "difficulty": question["difficulty"],
                    "topic_tags": question["topicTags"] or [],
                    "content": question.get("content", ""),
                }
            )
            print("  [OK]   Retrieved")

        except Exception as exc:
            failures.append(
                {
                    "submission_id": sub["id"],
                    "title": sub["title"],
                    "slug": sub["titleSlug"],
                    "status_display": sub["statusDisplay"],
                    "listed_lang": sub["lang"],
                    "timestamp": timestamp,
                    "timestamp_utc": utc_string(timestamp),
                    "reason": str(exc),
                }
            )
            print(f"  [FAIL] {exc}")

        time.sleep(0.25)

    return replayable, failures


def replay_submissions(replayable):
    latest_problem_meta = {}
    total = len(replayable)

    if not replayable:
        raise RuntimeError("No submission details were retrieved successfully.")

    original_branch, backup_branch = prepare_history_rewrite()
    setup_ts = replayable[0]["timestamp"] - 60

    setup_paths = [
        path
        for path in [".gitignore", ".env.example", "backfill.py"]
        if os.path.exists(os.path.join(REPO_PATH, path))
    ]
    if setup_paths:
        git_require(["add", "--"] + setup_paths)
        git_commit_with_date("chore: initialize repo structure", setup_ts)

    print("\n▶ Replaying submission history...\n")

    for index, submission in enumerate(replayable, 1):
        folder_name, ext = save_submission_snapshot(submission)
        latest_problem_meta[submission["question_id"]] = {
            "question_id": submission["question_id"],
            "title": submission["title"],
            "slug": submission["slug"],
            "difficulty": submission["difficulty"],
            "topic_tags": submission["topic_tags"],
        }

        git_require(["add", "--", folder_name])
        message = commit_message(submission)
        git_commit_with_date(message, submission["timestamp"], allow_empty=True)
        print(
            f"[{index:>4}/{total}] [COMMIT] {message} "
            f"-> {folder_name}/{folder_name}.{ext}"
        )

    print(f"\n▶ Finalizing reports on branch rewrite (backup: {backup_branch})...")
    return latest_problem_meta, original_branch, replayable[-1]["timestamp"]


def finalize_docs(latest_problem_meta, replayable_count, failures, original_branch, latest_submission_ts):
    problems = sorted(latest_problem_meta.values(), key=lambda item: int(item["question_id"]))

    print("▶ Generating README + failure reports...")
    readme = generate_main_readme(
        problems=problems,
        total_submissions=replayable_count,
        failed_submissions=len(failures),
    )
    with open(os.path.join(REPO_PATH, "README.md"), "w", encoding="utf-8") as fh:
        fh.write(readme)

    write_failure_reports(failures)

    git_require(["add", "--", "README.md", FAILURES_JSON, FAILURES_MD])

    docs_ts = max(latest_submission_ts + 60, int(datetime.now(tz=timezone.utc).timestamp()))
    git_commit_with_date("docs: update main README with full problem index", docs_ts)

    finalize_rewritten_branch(original_branch)


def main():
    print("╔══════════════════════════════════════╗")
    print("║ LeetCode Backfill · Full History     ║")
    print("╚══════════════════════════════════════╝\n")

    ensure_env()
    ensure_clean_worktree()

    all_submissions = fetch_all_submissions()
    print(f"\n✓ Found {len(all_submissions)} submissions in total")

    replayable, failures = fetch_submission_payloads(all_submissions)
    print(f"\n✓ Retrieved details for {len(replayable)} submissions")
    print(f"⚠️  Failed to retrieve {len(failures)} submissions")

    latest_problem_meta, original_branch, latest_submission_ts = replay_submissions(replayable)
    finalize_docs(
        latest_problem_meta,
        len(replayable),
        failures,
        original_branch,
        latest_submission_ts,
    )

    print("\n╔══════════════════════════════════════╗")
    print("║              Summary                 ║")
    print("╠══════════════════════════════════════╣")
    print(f"║  🧾 Replayed : {len(replayable):<23}║")
    print(f"║  ⚠️  Failed   : {len(failures):<23}║")
    print(f"║  📁 Problems : {len(latest_problem_meta):<23}║")
    print("╚══════════════════════════════════════╝")
    print("\nGenerated:")
    print(f"  - {FAILURES_JSON}")
    print(f"  - {FAILURES_MD}")
    print("\nNext:")
    print(f"  cd {REPO_PATH}")
    print("  git push --force origin $(git branch --show-current)\n")


if __name__ == "__main__":
    main()
