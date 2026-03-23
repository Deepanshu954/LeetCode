class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // Adj List

        List<int[]>[] adj = new ArrayList[n+1];
        for(int i = 0;i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int[] time : times) {
            int u = time[0];
            int v = time[1];
            int w = time[2];

            adj[u].add(new int[]{v, w});
        }

        // Dijkstra

        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        pq.offer(new int[]{0, k});

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int d = curr[0];
            int u = curr[1];

            if(d > dist[u]) continue;

            for(int[] edge : adj[u]) {
                int v = edge[0];
                int w = edge[1];

                if(d + w < dist[v]) {
                    dist[v] = d + w;
                    pq.offer(new int[]{dist[v], v});
                }
            }
        }

        int maxDist = 0;
        for(int i = 1; i <= n; i++) {
            if(dist[i] == Integer.MAX_VALUE) return -1;

            //maxDist = Math.max(maxDist, dist[i]);
            if(maxDist < dist[i]) maxDist = dist[i];
        }

        return maxDist;
    }
}