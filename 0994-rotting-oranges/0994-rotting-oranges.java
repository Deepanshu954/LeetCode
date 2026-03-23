class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;

        Queue<int[]> rq = new ArrayDeque<>();

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) fresh++;
                else if(grid[i][j] == 2) rq.offer(new int[]{i,j});
            }
        }

        if(fresh == 0) return 0;

        int min = 0;
        int[][] dir = {
            { 1, 0},
            {-1, 0},
            { 0, 1},
            { 0,-1}
        };

        while(!rq.isEmpty()) {
            int size = rq.size();

            for(int i = 0; i < size; i++) {
                int[] curr = rq.poll();
                int x = curr[0];
                int y = curr[1];

                for(int[] d: dir) {
                    int nx = x + d[0];
                    int ny = y + d[1];

                    if(nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == 1) {
                        grid[nx][ny] = 2;
                        fresh--;
                        rq.offer(new int[]{nx, ny});
                    }
                }
            }

            min++;
        }

        return fresh == 0 ? min - 1 : -1;
    }
}