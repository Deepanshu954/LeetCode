class Solution {
    private int[][] dp;
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        dp = new int[m][n];
        for(int[] d : dp) Arrays.fill(d, -1);

        return rec(m-1, n-1, grid);
    }

    private int rec(int m, int n, int[][] grid) {
        if(m == 0 && n == 0) return grid[0][0];
        if(m < 0 || n < 0) return (int)1e9;
        if(dp[m][n] != -1) return dp[m][n];

        int left = grid[m][n] + rec(m-1, n, grid);
        int right = grid[m][n] + rec(m, n-1, grid);

        return dp[m][n] = Math.min(left, right);
    }
}

/*

// Brute Force

class Solution {
    
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        return rec(m-1, n-1, grid);
    }

    private int rec(int m, int n, int[][] grid) {
        if(m == 0 && n == 0) return grid[0][0];
        if(m < 0 || n < 0) return (int)1e9;

        int left = grid[m][n] + rec(m-1, n, grid);
        int right = grid[m][n] + rec(m, n-1, grid);

        return Math.min(left, right);
    }
}

*/