class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        return rec(text1.length()-1, text2.length()-1, text1, text2);
    }
    
    private int rec(int s1, int s2, String text1, String text2) {
        if(s1 < 0 || s2 < 0) return 0;

        if(text1.charAt(s1) == text2.charAt(s2)) {
            return 1 + rec(s1 - 1, s2 - 1, text1, text2);
        }

        return Math.max(
            rec(s1, s2 - 1, text1, text2),
            rec(s1 - 1, s2, text1, text2)
        );
    }
}