class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<int[]>[] adj = new ArrayList[n];

        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList<>();

        for (int[] f : flights)
            adj[f[0]].add(new int[] { f[1], f[2] });

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> a[2] - b[2]
        );

        pq.offer(new int[] { 0, src, 0 });

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int s = curr[0];
            int u = curr[1];
            int d = curr[2];

            if (s > k)
                continue;

            for (int[] e : adj[u]) {
                int v = e[0];
                int w = e[1];

                if (d + w < dist[v]) {
                    dist[v] = d + w;
                    pq.offer(new int[] { s + 1, v, dist[v] });
                }
            }
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];

    }
}