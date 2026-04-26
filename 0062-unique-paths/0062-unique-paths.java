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