class Solution {
    private int maxArea = 0;
    private int area = 0;
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for(int i = 0; i < m; i++) {
            if(grid[i][0] == 1) dfs(grid,i,0);
            if(grid[m-1][0] == 1) dfs(grid,m-1,0);
        }

        for(int i = 0; i < n; i++) {
            if(grid[0][i] == 1) dfs(grid,0,i);
            if(grid[0][n-1] == 1) dfs(grid,0,n-1);
        }

        area = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    area = 0;
                    dfs(grid,i,j);
                }
                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }

    private void dfs(int[][] grid, int r, int c) {
        int m = grid.length;
        int n = grid[0].length;

        if(r < 0 || c < 0 || r >= m || c >= n || grid[r][c] == 0) return;
        grid[r][c] = 0;

        area++;

        dfs(grid, r-1, c);
        dfs(grid, r+1, c);
        dfs(grid, r, c-1);
        dfs(grid, r, c+1);
    }
}