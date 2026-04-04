class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] adj = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] e : times) {
            int u = e[0];
            int v = e[1];
            int w = e[2];

            adj[u].add(new int[] { v, w });
        }

        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> a[0] - b[0]
        ); // { dist, node}

        pq.offer(new int[]{0, k});

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int d = curr[0];
            int u = curr[1];

            if(d > dist[u]) continue;

            for(int[] e : adj[u]) {
                int v = e[0];
                int w = e[1];

                if(dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.offer(new int[]{ dist[v], v});
                }
            }
        }

        int min = 0;
        for(int i = 1; i <= n; i++) {
            if(dist[i] == Integer.MAX_VALUE) return -1;
            min = Math.max(min, dist[i]);
        }

        return min;

    }
}