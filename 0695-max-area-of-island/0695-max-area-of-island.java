class Solution {
    private int m,n;
    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        int maxArea = 0;
        boolean[][] vis = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !vis[i][j]) {
                    int area = dfs(grid, i, j, vis);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }

        return maxArea;
    }

    private int dfs(int[][] grid, int r, int c, boolean[][] vis) {
        if (r < 0 || c < 0 || r >= m || c >= n || grid[r][c] == 0 || vis[r][c])
            return 0;

        vis[r][c] = true;
        grid[r][c] = 0;

        return 1 + dfs(grid, r - 1, c, vis)
        + dfs(grid, r + 1, c, vis)
        + dfs(grid, r, c - 1, vis)
        + dfs(grid, r, c + 1, vis);
    }
}