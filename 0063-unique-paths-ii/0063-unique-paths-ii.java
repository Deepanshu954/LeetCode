class Solution {
    private int[][] dp;
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        dp = new int[m][n];
        for(int[] d : dp) Arrays.fill(d, -1);

        return helper(m-1,n-1, grid);
    }

    private int helper(int m, int n, int[][] grid) {
        if(m < 0 || n < 0) return 0;
        if(grid[m][n] == 1) return 0;
        if(m == 0 && n == 0) return 1;
        
        if(dp[m][n] != -1) return dp[m][n];

        int left = helper(m - 1, n, grid);
        int right = helper(m, n - 1, grid);

        return dp[m][n] = left + right;
    }
}
