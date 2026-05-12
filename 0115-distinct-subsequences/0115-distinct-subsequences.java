// Tabular

class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();

        int[][] dp = new int[m+1][n+1];

        for(int i = 0; i <= m; i++) dp[i][0] = 1;

        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                dp[i][j] = dp[i-1][j];

                if(s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j] += dp[i-1][j-1];
                }
            }
        }

        return dp[m][n];
    }
}




/*

// Recursion

class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();

        return rec(m-1, n-1, s, t);
    }

    private int rec(int i, int j, String s, String t) {
        if(j < 0) return 1;
        if(i < 0) return 0;

        if(s.charAt(i) == t.charAt(j)) {
            return rec(i-1, j-1, s, t) + rec(i-1, j, s, t);
        }

        return rec(i-1, j, s, t);
    }

}

*/

/*


// Memorization

class Solution {
    private int[][] dp;
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();

        dp = new int[m+1][n+1];
        for(int[] d : dp) Arrays.fill(d, -1);

        return rec(m-1, n-1, s, t);
    }

    private int rec(int i, int j, String s, String t) {
        if(j < 0) return 1;
        if(i < 0) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        if(s.charAt(i) == t.charAt(j)) {
            dp[i][j] = rec(i-1, j-1, s, t) + rec(i-1, j, s, t);
        } else {
            dp[i][j] = rec(i-1, j, s, t);
        }

        return dp[i][j];
    }

}

*/