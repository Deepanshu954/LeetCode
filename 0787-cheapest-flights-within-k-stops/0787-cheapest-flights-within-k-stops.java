class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<int[]>[] adj = new ArrayList[n];

        for(int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        for(int[] f : flights) adj[f[0]].add(new int[]{f[1], f[2]});

        int[][] dist = new int[n][k+2];
        for(int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[src][0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> a[2] - b[2]
        ); // {stops, node, dist}

        pq.offer(new int[]{0, src, 0});

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int s = curr[0];
            int u = curr[1];
            int d = curr[2];

            if(s > k) continue;

            for(int[] e : adj[u]) {
                int v = e[0];
                int w = e[1];

                if(d + w < dist[v][s+1]) {
                    dist[v][s+1] = d + w;
                    pq.offer(new int[]{s+1, v, d + w});
                }
            }
        }

        int ans = Integer.MAX_VALUE;

        for(int i = 0; i <= k + 1; i++) {
            ans = Math.min(ans, dist[dst][i]);
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;

    }
}