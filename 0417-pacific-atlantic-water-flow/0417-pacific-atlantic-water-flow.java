class Solution {
    private int m, n;
    private int[][] dir = { {-1,0},{1,0},{0,-1},{0,1} };

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;

        boolean[][] pac = new boolean[m][n];
        boolean[][] atl = new boolean[m][n];

        // Pacific (top + left)
        for(int i = 0; i < m; i++) {
            dfs(heights, i, 0, pac);       // left
            dfs(heights, i, n-1, atl);     // right
        }

        for(int j = 0; j < n; j++) {
            dfs(heights, 0, j, pac);       // top
            dfs(heights, m-1, j, atl);     // bottom
        }

        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(pac[i][j] && atl[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }

        return res;
    }

    private void dfs(int[][] h, int r, int c, boolean[][] vis) {
        vis[r][c] = true;

        for (int[] d : dir) {
            int nr = r + d[0];
            int nc = c + d[1];

            if (nr >= 0 && nc >= 0 && nr < m && nc < n
                && !vis[nr][nc]
                && h[nr][nc] >= h[r][c]) {

                dfs(h, nr, nc, vis);
            }
        }
    }
}