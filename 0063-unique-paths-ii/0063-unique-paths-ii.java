// Space Optimization

class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // edge case
        if(grid[0][0] == 1 || grid[m-1][n-1] == 1) return 0;

        int[] dp = new int[n];
        dp[0] = (grid[0][0] == 1) ? 0 : 1;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {

                if(grid[i][j] == 1) dp[j] = 0;
                else if(j > 0){
                    dp[j] = dp[j] + dp[j-1];
                }
            }
        }

        return dp[n-1];
    }
}


/*

// Memorization

import java.util.*;

class Solution {
    private int m, n;
    private int[][] dp;

    public int uniquePathsWithObstacles(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        if (grid[0][0] == 1 || grid[m-1][n-1] == 1) return 0;

        dp = new int[m][n];
        for (int[] d : dp) Arrays.fill(d, -1);

        return rec(m - 1, n - 1, grid);
    }

    private int rec(int r, int c, int[][] grid) {
        if (r < 0 || c < 0) return 0;
        if (grid[r][c] == 1) return 0;
        if (r == 0 && c == 0) return 1;

        if (dp[r][c] != -1) return dp[r][c];

        return dp[r][c] = rec(r - 1, c, grid) + rec(r, c - 1, grid);
    }
}

*/

/*

// tabular

class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        // edge case
        if(grid[0][0] == 1 || grid[m-1][n-1] == 1) return 0;

        // Base Case
        dp[0][0] = 1;

        for(int i = 1; i < m; i++) {
            if(grid[i][0] == 1) dp[i][0] = 0;
            else dp[i][0] = dp[i-1][0]; 
        }
        for(int j = 1; j < n; j++) {
            if(grid[0][j] == 1) dp[0][j] = 0;
            else dp[0][j] = dp[0][j-1];
        }

        // recursive part

        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(grid[i][j] == 1) dp[i][j] = 0;
                else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }

        return dp[m-1][n-1];
    }
}

*/