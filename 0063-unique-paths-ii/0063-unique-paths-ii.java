class Solution {
    private int m,n;
    public int uniquePathsWithObstacles(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        return rec(m-1, n-1,grid);
    }

    private int rec(int m, int n, int[][] grid) {
        if(m == 0 && n == 0) return 1;
        if(m < 0 || n < 0) return 0;
        if(grid[m][n] == 1) return 0;

        return rec(m-1, n, grid) + rec(m, n-1, grid);
    }
}