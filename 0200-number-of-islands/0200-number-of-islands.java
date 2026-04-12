class Solution {
    private int m, n;

    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;

        int comp = 0;
        boolean[][] vis = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !vis[i][j]) {
                    dfs(grid, i, j, vis);
                    comp++;
                }
            }
        }

        return comp;
    }

    private void dfs(char[][] grid, int r, int c, boolean[][] vis) {
        if (r < 0 || c < 0 || r >= m || c >= n || grid[r][c] == '0' || vis[r][c])
            return;

        vis[r][c] = true;
        grid[r][c] = '0';

        dfs(grid, r - 1, c, vis);
        dfs(grid, r + 1, c, vis);
        dfs(grid, r, c - 1, vis);
        dfs(grid, r, c + 1, vis);
    }
}