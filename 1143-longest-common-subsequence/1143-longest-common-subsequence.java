// Tabular

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int s1 = text1.length();
        int s2 = text2.length();

        int[][] dp = new int[s1+1][s2+1];

        // Base Case


        // Rest
        for(int i = 1; i <= s1; i++) {
            for(int j = 1; j <= s2; j++) {

                if(text1.charAt(i-1) == text2.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];

                else
                    dp[i][j] = Math.max( dp[i-1][j], dp[i][j-1] );
            }
        }

        return dp[s1][s2];
    }
}


/*

// Memorization

class Solution {
    private int[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        int s1 = text1.length();
        int s2 = text2.length();

        dp = new int[s1+1][s2+1];
        for(int[] d : dp) Arrays.fill(d, -1);

        return rec(s1 - 1, s2 - 1, text1, text2);
    }
    
    private int rec(int s1, int s2, String text1, String text2) {
        if(s1 < 0 || s2 < 0) return 0;

        if(dp[s1][s2] != -1) return dp[s1][s2];

        if(text1.charAt(s1) == text2.charAt(s2)) {
            return dp[s1][s2] = 1 + rec(s1 - 1, s2 - 1, text1, text2);
        }

        return dp[s1][s2] = Math.max(
            rec(s1, s2 - 1, text1, text2),
            rec(s1 - 1, s2, text1, text2)
        );
    }
}

*/

/*

// Recursion

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

*/

