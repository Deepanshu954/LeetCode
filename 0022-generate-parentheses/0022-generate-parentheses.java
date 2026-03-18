class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();

        helper(0 , 0, n, "", res);
        return res;
    }

    private void helper(int open, int close, int n,String str, List<String> res) {
        if(open == n && close == n) {
            res.add(str);
            return;
        }

        if(open < n) {
            helper(open + 1, close, n, str + "(", res);
        }

        if(close < open) {
            helper(open, close + 1, n, str + ")", res);
        }
    }
}