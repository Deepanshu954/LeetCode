class Solution {
    private int m, n;

    public int[][] colorBorder(int[][] grid, int r, int c, int color) {
        this.m = grid.length;
        this.n = grid[0].length;

        boolean[][] vis = new boolean[m][n];
        dfs(grid, vis, r, c, grid[r][c], color);
        return grid;
    }

    public void dfs(int[][] grid, boolean[][] vis, int r, int c, int oc, int nc) {
        if (r < 0 || c < 0 || r >= m || c >= n || vis[r][c] || grid[r][c] != oc) return;

        vis[r][c] = true;
        boolean border = false;

        // check boundary
        if (r == 0 || c == 0 || r == m - 1 || c == n - 1) {
            border = true;
        }

        // check neighbors
        if (r > 0 && grid[r - 1][c] != oc) border = true;
        if (r < m - 1 && grid[r + 1][c] != oc) border = true;
        if (c > 0 && grid[r][c - 1] != oc) border = true;
        if (c < n - 1 && grid[r][c + 1] != oc) border = true;

        dfs(grid, vis, r + 1, c, oc, nc);
        dfs(grid, vis, r - 1, c, oc, nc);
        dfs(grid, vis, r, c + 1, oc, nc);
        dfs(grid, vis, r, c - 1, oc, nc);

        if (border) grid[r][c] = nc;
    }
}