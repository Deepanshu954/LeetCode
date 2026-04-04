class Solution {
    public int minimumEffortPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dist = new int[m][n];
        for(int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        dist[0][0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> a[0] - b[0]
        ); // {effort, row, col}

        pq.offer(new int[]{0,0,0});

        int[][] dir = {
            {-1,0},
            { 1,0},
            {0,-1},
            {0,1}
        };

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int e = curr[0];
            int r = curr[1];
            int c = curr[2];

            if(r == m-1 && c == n-1) return e;

            if(e > dist[r][c]) continue;

            for(int[] d : dir) {
                int nr = r + d[0];
                int nc = c + d[1];

                if(nr < 0 || nr >= m || nc < 0 || nc >= n) continue;

                int diff = Math.abs(grid[r][c] - grid[nr][nc]);
                int ne = Math.max(e, diff);

                if(ne < dist[nr][nc]) {
                    dist[nr][nc] = ne;
                    pq.offer(new int[]{ne, nr, nc}); // FIXED
                }
            }
        }

        return 0;
    }
}