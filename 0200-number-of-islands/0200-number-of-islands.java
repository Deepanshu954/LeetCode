class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int res = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    res++;
                    bfs(grid,i,j);
                } 
            }
        }

        return res;
    }

    private void bfs(char[][] grid, int sr, int sc) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sr,sc});
        grid[sr][sc] = '0';

        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];

            for(int[] d : dir) {
                int nr = r + d[0];
                int nc = c + d[1];

                if(nr >= 0 && nc >= 0 && nr < m && nc < n && grid[nr][nc] == '1') {
                    grid[nr][nc] = '0';
                    q.offer(new int[]{nr,nc});
                }
            }
        }
    }

    private void dfs(char[][] grid, int r, int c) {
        int m = grid.length;
        int n = grid[0].length;

        if(r < 0 || c < 0 || r >= m || c >= n || grid[r][c] == '0') return;

        grid[r][c] = '0';

        dfs(grid, r-1, c);
        dfs(grid, r+1, c);
        dfs(grid, r, c-1);
        dfs(grid, r, c+1);
    }
}