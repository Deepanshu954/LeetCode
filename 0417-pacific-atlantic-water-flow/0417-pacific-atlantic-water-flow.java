class Solution {
    private int m, n;
    private int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public List<List<Integer>> pacificAtlantic(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        boolean[][] pac = new boolean[m][n];
        boolean[][] atl = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            dfs(grid, i, 0, pac);
            dfs(grid, i, n - 1, atl);
        }

        for (int j = 0; j < n; j++) {
            dfs(grid, 0, j, pac);
            dfs(grid, m - 1, j, atl);
        }

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pac[i][j] && atl[i][j])
                    res.add(Arrays.asList(i, j));
            }
        }

        return res;
    }

    private void dfs(int[][] grid, int r, int c, boolean[][] vis) {
        vis[r][c] = true;

        for (int[] d : dir) {
            int nr = r + d[0];
            int nc = c + d[1];

            if (nr < 0 || nr >= m || nc < 0 || nc >= n || vis[nr][nc])
                continue;
            if (grid[nr][nc] < grid[r][c])
                continue;

            dfs(grid, nr, nc, vis);
        }
    }
}