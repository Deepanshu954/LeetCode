class Solution {
    private int m, n;

    public boolean containsCycle(char[][] grid) {
        m = grid.length;
        n = grid[0].length;

        boolean[][] vis = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!vis[i][j]) {
                    if (dfs(i, j, -1, -1, grid, vis)) return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(int r, int c, int pr, int pc, char[][] grid, boolean[][] vis) {

        vis[r][c] = true;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr < 0 || nc < 0 || nr >= m || nc >= n) continue;
            if (grid[nr][nc] != grid[r][c]) continue;

            if (!vis[nr][nc]) {
                if (dfs(nr, nc, r, c, grid, vis)) return true;
            } else if (nr != pr || nc != pc) {
                return true; // cycle found
            }
        }

        return false;
    }
}