class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        return rec(m-1, n-1, grid);
    }

    private int rec(int r, int c, int[][] grid) {
        if(r < 0 || c < 0) return (int)1e9;
        if(r == 0 && c == 0) return grid[r][c];

        return grid[r][c] + Math.min(rec(r-1, c, grid), rec(r, c-1, grid));
    }
}