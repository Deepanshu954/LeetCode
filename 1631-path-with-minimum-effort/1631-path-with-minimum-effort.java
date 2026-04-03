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
            {1,0},
            {0,-1},
            {0,1}
        };

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int effort = curr[0];
            int r = curr[1];
            int c = curr[2];

            if(r == m-1 && c == n-1) return effort;

            for(int[] d : dir) {
                int nr = r + d[0];
                int nc = c + d[1];

                if(nr < 0 || nc < 0 || nr >= m || nc >= n) continue;

                int diff = Math.abs(grid[r][c] - grid[nr][nc]);
                int newEffort = Math.max(effort, diff);

                if(newEffort < dist[nr][nc]) {
                    dist[nr][nc] = newEffort;
                    pq.offer(new int[]{newEffort, nr, nc});
                }

            }

        }

        return 0;
    }
}