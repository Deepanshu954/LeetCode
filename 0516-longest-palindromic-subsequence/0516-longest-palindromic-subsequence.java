// Tabular

class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();

        int[][] dp = new int[n][n];

        for(int i = 0; i < n; i++) dp[i][i] = 1;

        for(int i = n-1; i >= 0; i--) {
            for(int j = i+1; j < n; j++) {

                if(s.charAt(i) == s.charAt(j)) dp[i][j] = 2 + dp[i+1][j-1];
                else dp[i][j] = Math.max(
                    dp[i+1][j],
                    dp[i][j-1]
                );
            }
        }

        return dp[0][n-1];
    }
}

/*

// Recursion

class Solution {
    public int longestPalindromeSubseq(String s) {
        return rec(0, s.length() - 1, s);
    }

    private int rec(int i, int j, String s) {
        if(i > j) return 0;
        if(i == j) return 1;

        if(s.charAt(i) == s.charAt(j)) {
            return 2 + rec(i+1, j-1, s);
        }

        return Math.max(
            rec(i+1, j, s),
            rec(i, j-1, s)
        );
    }
}

*/

/*

// Memorization

class Solution {
    private int[][] dp;
    public int longestPalindromeSubseq(String s) {
        int n = s.length();

        dp = new int[n+1][n+1];
        for(int[] d : dp) Arrays.fill(d, -1);

        return rec(0, n - 1, s);
    }

    private int rec(int i, int j, String s) {
        if(i > j) return 0;
        if(i == j) return 1;

        if(dp[i][j] != -1) return dp[i][j];

        if(s.charAt(i) == s.charAt(j)) {
            return dp[i][j] = 2 + rec(i+1, j-1, s);
        }

        return dp[i][j] = Math.max(
            rec(i+1, j, s),
            rec(i, j-1, s)
        );
    }
}

*/