import os
import time
import subprocess
from datetime import datetime
import requests
from markdownify import markdownify as md

LEETCODE_SESSION = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfYXV0aF91c2VyX2lkIjoiMTczODM4NjYiLCJfYXV0aF91c2VyX2JhY2tlbmQiOiJkamFuZ28uY29udHJpYi5hdXRoLmJhY2tlbmRzLk1vZGVsQmFja2VuZCIsIl9hdXRoX3VzZXJfaGFzaCI6IjI4MDY4MTBkMjA2MmIxMmQ5NGEyNjk4MTEzMjlmYWE5OTgxODYzODU4NmZiYjE0ODg0ZDVjMzJlMDU3OGYzOTIiLCJzZXNzaW9uX3V1aWQiOiJkMWU4MWIyMyIsImlkIjoxNzM4Mzg2NiwiZW1haWwiOiJkZWVwYW5zaHVjaGF1aGFuOTcxOTE5QGdtYWlsLmNvbSIsInVzZXJuYW1lIjoiZGVlcGFuc2h1OTU0IiwidXNlcl9zbHVnIjoiZGVlcGFuc2h1OTU0IiwiYXZhdGFyIjoiaHR0cHM6Ly9hc3NldHMubGVldGNvZGUuY29tL3VzZXJzL2RlZXBhbnNodTk1NC9hdmF0YXJfMTc3MjU4NjY1NC5wbmciLCJyZWZyZXNoZWRfYXQiOjE3ODM5OTg0ODEsImlwIjoiMjQwMTo0OTAwOjg2YmQ6NGQ0NjpkOTQxOmM1NGM6NThkZjplZDhkIiwiaWRlbnRpdHkiOiI0ZmMwN2JhNTk5ZjlkODRhYzJjNWYzZDM2YmU1YWFkZiIsImRldmljZV93aXRoX2lwIjpbIjRkMGExNThkN2I1MmE0NTMyOGU4MzZkOGVkNjBlMzNmIiwiMjQwMTo0OTAwOjg2YmQ6NGQ0NjpkOTQxOmM1NGM6NThkZjplZDhkIl0sIl9zZXNzaW9uX2V4cGlyeSI6MTIwOTYwMH0.Xdxt4vCw-zdhC2ozjhXuRCdN5VqqOe7SxZKt7Y-2OzU"
CSRF_TOKEN = "uNB4vlYtfOQcpworgHGQpkfyUTKUR4H6"
REPO_DIR = "."

HEADERS = {
    "Content-Type": "application/json",
    "Cookie": f"LEETCODE_SESSION={LEETCODE_SESSION}; csrftoken={CSRF_TOKEN}",
    "x-csrftoken": CSRF_TOKEN,
    "Referer": "https://leetcode.com/submissions/",
}

SUBMISSIONS_QUERY = """
query submissionList($offset: Int!, $limit: Int!, $lastKey: String) {
  submissionList(offset: $offset, limit: $limit, lastKey: $lastKey) {
    lastKey
    hasNext
    submissions {
      id
      statusDisplay
      lang
      timestamp
      title
      titleSlug
    }
  }
}
"""

DETAIL_QUERY = """
query submissionDetails($submissionId: Int!) {
  submissionDetails(submissionId: $submissionId) {
    code
  }
}
"""

QUESTION_QUERY = """
query questionData($titleSlug: String!) {
  question(titleSlug: $titleSlug) {
    questionFrontendId
    content
  }
}
"""

EXT_MAP = {
    "python3": "py", "python": "py", "java": "java", "cpp": "cpp", "c": "c",
    "javascript": "js", "typescript": "ts", "csharp": "cs", "go": "go",
    "kotlin": "kt", "swift": "swift", "rust": "rs",
}

def graphql(query, variables, retries=5):
    for attempt in range(retries):
        try:
            resp = requests.post(
                "https://leetcode.com/graphql", json={"query": query, "variables": variables},
                headers=HEADERS, timeout=15,
            )
            resp.raise_for_status()
            data = resp.json()
            if "errors" in data:
                raise RuntimeError(data["errors"])
            return data["data"]
        except requests.exceptions.RequestException as e:
            if attempt < retries - 1:
                sleep_time = (attempt + 1) * 2
                print(f"Request failed ({e}). Retrying in {sleep_time}s...")
                time.sleep(sleep_time)
            else:
                raise e

def fetch_all_submissions():
    submissions = []
    offset, last_key = 0, None
    while True:
        data = graphql(SUBMISSIONS_QUERY, {"offset": offset, "limit": 20, "lastKey": last_key})["submissionList"]
        for s in data["submissions"]:
            submissions.append(s)
        if not data["hasNext"]:
            break
        offset += 20
        last_key = data["lastKey"]
        time.sleep(0.4)
    return submissions

def fetch_code(submission_id):
    return graphql(DETAIL_QUERY, {"submissionId": int(submission_id)})["submissionDetails"]["code"]

def fetch_question(title_slug):
    data = graphql(QUESTION_QUERY, {"titleSlug": title_slug})["question"]
    return data

def git(args, cwd, env=None):
    subprocess.run(["git", *args], cwd=cwd, check=True, env=env)

def backdated_commit(repo_dir, filepaths, message, dt: datetime):
    date_str = dt.strftime("%Y-%m-%dT%H:%M:%S")
    env = os.environ.copy()
    env["GIT_AUTHOR_DATE"] = date_str
    env["GIT_COMMITTER_DATE"] = date_str
    for fp in filepaths:
        git(["add", fp], cwd=repo_dir)
    git(["commit", "--allow-empty", "-m", message], cwd=repo_dir, env=env)

def main():
    print("Fetching submission list...")
    submissions = fetch_all_submissions()
    submissions.sort(key=lambda s: int(s["timestamp"]))
    print(f"Found {len(submissions)} submissions.")

    question_cache = {}

    for s in submissions:
        slug = s["titleSlug"]
        
        # Fetch question details if we haven't seen it yet
        if slug not in question_cache:
            q_data = fetch_question(slug)
            question_cache[slug] = q_data
            time.sleep(0.4)
            
        q = question_cache[slug]
        frontend_id = int(q["questionFrontendId"])
        folder_name = f"{frontend_id:04d}-{slug}"
        
        full_folder_path = os.path.join(REPO_DIR, folder_name)
        os.makedirs(full_folder_path, exist_ok=True)
        
        # Save README.md
        readme_path = os.path.join(folder_name, "README.md")
        full_readme_path = os.path.join(REPO_DIR, readme_path)
        if not os.path.exists(full_readme_path):
            markdown_content = f"# {frontend_id}. {s['title']}\n\n{md(q['content'] or '')}"
            with open(full_readme_path, "w") as f:
                f.write(markdown_content)
        
        # Save solution code
        code = fetch_code(s["id"])
        ext = EXT_MAP.get(s["lang"], "txt")
        code_filename = f"{folder_name}.{ext}"
        code_rel_path = os.path.join(folder_name, code_filename)
        full_code_path = os.path.join(REPO_DIR, code_rel_path)
        
        with open(full_code_path, "w") as f:
            f.write(code)

        dt = datetime.fromtimestamp(int(s["timestamp"]))
        commit_msg = f"{s['statusDisplay']}: {s['title']}"
        backdated_commit(REPO_DIR, [readme_path, code_rel_path], commit_msg, dt)
        print(f"  committed {folder_name} [{s['statusDisplay']}] @ {dt}")
        time.sleep(0.4)

    # Generate root README.md
    print("Generating root README.md...")
    folders = [f for f in os.listdir(REPO_DIR) if os.path.isdir(os.path.join(REPO_DIR, f)) and f[0].isdigit()]
    folders.sort(key=lambda x: int(x.split('-')[0]))

    readme_content = "# LeetCode 🚀\n\nThis repository contains my solutions to LeetCode problems. The history is fully synced with my LeetCode submissions, automatically backdated to accurately reflect my learning journey!\n\n## 📝 Solutions\n\n| # | Title | Solution |\n|---| ----- | -------- |\n"

    for folder in folders:
        parts = folder.split('-', 1)
        if len(parts) != 2: continue
        frontend_id = int(parts[0])
        slug = parts[1]
        title = " ".join([word.capitalize() for word in slug.split('-')])
        
        solution_file = None
        for f in os.listdir(os.path.join(REPO_DIR, folder)):
            if f != "README.md":
                solution_file = f
                break
                
        if solution_file:
            lang = solution_file.split('.')[-1].upper()
            if lang == "PY": lang = "Python"
            if lang == "CPP": lang = "C++"
            if lang == "JAVA": lang = "Java"
            readme_content += f"| {frontend_id:04d} | [{title}](./{folder}/README.md) | [{lang}](./{folder}/{solution_file}) |\n"

    with open(os.path.join(REPO_DIR, "README.md"), "w") as f:
        f.write(readme_content)
        
    git(["add", "README.md"], cwd=REPO_DIR)
    git(["commit", "-m", "docs: update root README.md with solutions index"], cwd=REPO_DIR)

    print("Done. Push with: git push origin main --force")

if __name__ == "__main__":
    main()
