class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        return rec(n-1, m-1, s1, s2);
    }

    private int rec(int i, int j, String s1, String s2) {
        if(i < 0 || j < 0) return 0;

        if(s1.charAt(i) == s2.charAt(j)) return 1 + rec(i-1, j-1, s1, s2);

        return Math.max(
            rec(i-1, j, s1, s2),
            rec(i, j-1, s1, s2)
        );
    }
}