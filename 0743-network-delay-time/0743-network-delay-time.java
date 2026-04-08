class Solution {
    public int networkDelayTime(int[][] edges, int n, int k) {
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        for(int i = 1; i < n; i++) {
            boolean rel = false;
            for(int[] e : edges) {
                int u = e[0];
                int v = e[1];
                int w = e[2];

                if(dist[u] == Integer.MAX_VALUE) continue;

                if(dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    rel = true;
                }
            }

            if(!rel) break;
        }

        int min = 0;
        for(int i = 1; i <= n; i++) {
            if(dist[i] == Integer.MAX_VALUE) return -1;
            min = Math.max(min, dist[i]);
        }

        return min;
    }
}