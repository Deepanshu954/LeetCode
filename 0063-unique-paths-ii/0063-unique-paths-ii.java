class Solution {
    private int m,n;
    private int[][] dp;
    public int uniquePathsWithObstacles(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        if(grid[0][0] == 1) return 0;

        dp = new int[m][n];
        for(int[] d : dp) Arrays.fill(d, -1);
 

        return rec(m-1, n-1,grid);
    }

    private int rec(int m, int n, int[][] grid) {
        if(m < 0 || n < 0) return 0;
        if(m == 0 && n == 0) return 1;
        if(grid[m][n] == 1) return 0;
        if(dp[m][n] != -1) return dp[m][n];

        dp[m][n] = rec(m-1, n, grid) + rec(m, n-1, grid);
        return dp[m][n];
    }
}