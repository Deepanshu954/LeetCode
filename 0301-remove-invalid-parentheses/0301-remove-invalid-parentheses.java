class Solution {
    public List<String> removeInvalidParentheses(String s) {
        int l = 0, r = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                l++;
            } else if (c == ')') {
                if (l > 0) l--;
                else r++;
            }
        }

        Set<String> res = new HashSet<>();
        dfs(s, 0, l, r, 0, new StringBuilder(), res);
        return new ArrayList<>(res);
    }

    private void dfs(String s, int idx, int l, int r, int bal,
                     StringBuilder cur, Set<String> res) {
        if (idx == s.length()) {
            if (l == 0 && r == 0 && bal == 0) {
                res.add(cur.toString());
            }
            return;
        }

        char c = s.charAt(idx);

        if (c == '(' && l > 0) {
            dfs(s, idx + 1, l - 1, r, bal, cur, res);
        }

        if (c == ')' && r > 0) {
            dfs(s, idx + 1, l, r - 1, bal, cur, res);
        }

        cur.append(c);

        if (c != '(' && c != ')') {
            dfs(s, idx + 1, l, r, bal, cur, res);
        } else if (c == '(') {
            dfs(s, idx + 1, l, r, bal + 1, cur, res);
        } else if (bal > 0) {
            dfs(s, idx + 1, l, r, bal - 1, cur, res);
        }

        cur.deleteCharAt(cur.length() - 1);
    }
}