class Solution {
    private int[][] dp;
    public int uniquePaths(int m, int n) {
        dp = new int[m][n];
        for(int[] d : dp) Arrays.fill(d, -1);
        return helper(m-1,n-1);
    }

    private int helper(int m, int n) {
        if(m == 0 || n == 0) return 1;
        if(dp[m][n] != -1) return dp[m][n];

        int left = helper(m - 1, n);
        int right = helper(m, n - 1);

        return dp[m][n] = left + right;
    }
}