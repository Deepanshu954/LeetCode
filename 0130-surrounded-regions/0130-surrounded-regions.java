class Solution {
    private int m,n;

    public void solve(char[][] grid) {
        m = grid.length;
        n = grid[0].length;

        for(int i = 0; i < m; i++) {
            if(grid[i][0] == 'O') dfs(grid, i, 0);
            if(grid[i][n-1] == 'O') dfs(grid, i, n-1);
        }

        for(int j = 0; j < n; j++) {
            if(grid[0][j] == 'O') dfs(grid, 0, j);
            if(grid[m-1][j] == 'O') dfs(grid, m-1, j);
        }


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'T') grid[i][j] = 'O';
                else if(grid[i][j] == 'O') grid[i][j] = 'X';
            }
        }
        return;
    }

    private void dfs(char[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= m || c >= n || grid[r][c] == 'X')
            return;

        grid[r][c] = 'T';

        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }
}