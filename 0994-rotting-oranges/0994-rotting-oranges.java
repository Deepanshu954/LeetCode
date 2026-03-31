class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int fresh = 0;
        Queue<int[]> q = new ArrayDeque<>();

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) fresh++;
                else if(grid[i][j] == 2) q.offer(new int[]{i,j});
            }
        }

        if(fresh == 0) return 0;
        if(q.isEmpty()) return -1;

        int min = 0;

        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];

            boolean rot = false;

            for(int[] d : dir) {
                int nr = r + d[0];
                int nc = c + d[1];

                if(nr >= 0 && nc >= 0 && nr < m && nc < n && grid[nr][nc] == 1) {
                    fresh--;
                    grid[nr][nc] = 2;
                    q.offer(new int[]{nr,nc});
                    rot = true;
                }
            }

            if(rot) min++;
        }

        return fresh == 0 ? min -1 : -1;
    }
}