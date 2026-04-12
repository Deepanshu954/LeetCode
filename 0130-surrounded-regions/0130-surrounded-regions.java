class Solution {
    private int m,n;

    public void solve(char[][] grid) {
        m = grid.length;
        n = grid[0].length;

        boolean[][] vis = new boolean[m][n];

        for(int i = 0; i < m; i++) {
            if(grid[i][0] == 'O') dfs(grid, i, 0, vis);
            if(grid[i][n-1] == 'O') dfs(grid, i, n-1, vis);
        }

        for(int j = 0; j < n; j++) {
            if(grid[0][j] == 'O') dfs(grid, 0, j, vis);
            if(grid[m-1][j] == 'O') dfs(grid, m-1, j, vis);
        }


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'T') grid[i][j] = 'O';
                else if(grid[i][j] == 'O') grid[i][j] = 'X';
            }
        }
        return;
    }

    private void dfs(char[][] grid, int r, int c, boolean[][] vis) {
        if (r < 0 || c < 0 || r >= m || c >= n || grid[r][c] == 'X' || vis[r][c])
            return;

        vis[r][c] = true;
        grid[r][c] = 'T';

        dfs(grid, r - 1, c, vis);
        dfs(grid, r + 1, c, vis);
        dfs(grid, r, c - 1, vis);
        dfs(grid, r, c + 1, vis);
    }
}