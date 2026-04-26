class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        // base case
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 || j == 0) dp[i][j] = 1;
            }
        }

        // recursive part
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        
        return dp[m-1][n-1];
    }
}

/*

class Solution {
    private int[][] dp;
    public int uniquePaths(int m, int n) {
        dp = new int[m][n];
        for(int[] d : dp) Arrays.fill(d, -1);
        
        return rec(m-1,n-1);
    }

    private int rec(int m, int n) {
        if( m == 0 || n == 0) return 1;
        if(dp[m][n] != -1) return dp[m][n];

        dp[m][n] = rec(m-1, n) + rec(m, n-1);
        return dp[m][n];
    }
}

*/