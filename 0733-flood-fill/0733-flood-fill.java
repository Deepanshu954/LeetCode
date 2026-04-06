class Solution {
    public int[][] floodFill(int[][] grid, int sr, int sc, int color) {
        int m = grid.length;
        int n = grid[0].length;

        int base = grid[sr][sc];
        if(base == color) return grid;

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sr,sc});
        grid[sr][sc] = color;

        int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];

            for(int[] d : dir) {
                int nr = r + d[0];
                int nc = c + d[1];

                if(nr >= 0 && nc >= 0 && nr < m && nc < n && grid[nr][nc] == base) {
                    q.offer(new int[]{nr,nc});
                    grid[nr][nc] = color;
                }
            }
        }

        return grid;
    }
}