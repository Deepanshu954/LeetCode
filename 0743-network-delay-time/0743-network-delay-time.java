class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] adj = buildAdj(n, times);

        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> a[0] - b[0]
        );

        pq.offer(new int[]{0, k});

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int d = curr[0];
            int u = curr[1];

            if(d > dist[u]) continue; // 🔥 restore this

            for(int[] e : adj[u]) {
                int v = e[0];
                int w = e[1];

                if(dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.offer(new int[]{dist[v], v});
                }
            }
        }

        int max = 0;
        for(int i = 1; i <= n; i++) {
            if(dist[i] == Integer.MAX_VALUE) return -1;
            max = Math.max(max, dist[i]);
        }

        return max;
    }

    private List<int[]>[] buildAdj(int V, int[][] edges) {
        List<int[]>[] adj = new ArrayList[V+1];

        for(int i = 0; i <= V; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            adj[u].add(new int[]{v, w}); // 🔥 directed only
        }

        return adj;
    }
}