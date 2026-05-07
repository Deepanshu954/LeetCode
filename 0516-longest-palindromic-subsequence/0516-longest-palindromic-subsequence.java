class Solution {
    public int longestPalindromeSubseq(String s) {
        if(s.length() == 1) return 1;
        return rec(0, s.length() - 1, s);
    }

    private int rec(int i, int j, String s) {
        if(i > j) return 0;

        if(s.charAt(i) == s.charAt(j)) {
            return 2 + rec(i+1, j-1, s);
        }

        return Math.max(
            rec(i+1, j, s),
            rec(i, j-1, s)
        );
    }
}