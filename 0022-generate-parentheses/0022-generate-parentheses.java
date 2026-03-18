class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        helper(0 , 0, n, sb, res);
        return res;
    }

    private void helper(int open, int close, int n,StringBuilder str, List<String> res) {
        if(open == n && close == n) {
            res.add(str.toString());
            return;
        }

        if(open < n) {
            str.append("(");
            helper(open + 1, close, n, str, res);
            str.deleteCharAt(str.length() - 1);
        }

        if(close < open) {
            str.append(")");
            helper(open, close + 1, n, str, res);
            str.deleteCharAt(str.length() - 1);
        }
    }
}