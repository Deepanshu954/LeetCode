class Solution {
    private int m, n;

    int[][] dir = {
        {0, -1}, // left
        {0, 1},  // right
        {-1, 0}, // up
        {1, 0}   // down
    };

    int[][] type = {
        {},
        {0, 1}, // 1 → left, right
        {2, 3}, // 2 → up, down
        {1, 3}, // 3 → right, down
        {0, 3}, // 4 → left, down
        {0, 2}, // 5 → left, up
        {1, 2}  // 6 → right, up
    };

    public boolean hasValidPath(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        boolean[][] vis = new boolean[m][n];
        return dfs(grid, 0, 0, vis);
    }

    private boolean dfs(int[][] grid, int r, int c, boolean[][] vis) {
        if (r == m - 1 && c == n - 1) return true;

        vis[r][c] = true;

        for (int d : type[grid[r][c]]) {
            int nr = r + dir[d][0];
            int nc = c + dir[d][1];

            if (nr < 0 || nc < 0 || nr >= m || nc >= n || vis[nr][nc]) continue;

            int rev = d ^ 1;

            // check if neighbor allows reverse direction
            boolean canConnect = false;
            for (int nd : type[grid[nr][nc]]) {
                if (nd == rev) {
                    canConnect = true;
                    break;
                }
            }

            if (canConnect && dfs(grid, nr, nc, vis)) {
                return true;
            }
        }

        return false;
    }
}