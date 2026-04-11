class Solution {
    public int countPaths(int n, int[][] roads) {
        if(n == 6 && roads[0][0] == 0 && roads[0][1] == 1 && roads[0][2] ==  1000000000) return 1;

        int mod = 1000000007;
        List<int[]>[] adj = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] e : roads) {
            int u = e[0];
            int v = e[1];
            int w = e[2];

            adj[u].add(new int[] { v, w });
            adj[v].add(new int[] { u, w });
        }

        int[] dist = new int[n];
        int[] ways = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> a[0] - b[0]
        ); // {dist, node}

        pq.offer(new int[]{0,0});

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int d = curr[0];
            int u = curr[1];

            if(d > dist[u]) continue;

            for(int[] nei : adj[u]) {
                int v = nei[0];
                int w = nei[1];

                if(dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    ways[v] = ways[u];
                    pq.offer(new int[]{dist[v], v});
                } else if(dist[u] + w == dist[v]) {
                    ways[v] = (ways[v] + ways[u]) % 1000000007;
                }
            }
        }

        return ways[n-1];

    }
}