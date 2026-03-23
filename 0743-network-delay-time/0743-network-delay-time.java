class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for(int[] edge : times) {
            graph.computeIfAbsent(edge[0], x -> new ArrayList<>()).add(new int[]{edge[1], edge[2]});
        }

        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{k, 0});

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0]; // current Node
            int d = curr[1]; // current Distance

            if(d > dist[u]) continue;

            if(graph.containsKey(u)) {
                for(int[] nei : graph.get(u)) {
                    int nextNode = nei[0];
                    int nextDist = nei[1];

                    if(d + nextDist < dist[nextNode]) {
                        dist[nextNode] = d + nextDist;
                        pq.offer(new int[]{nextNode, d + nextDist});
                    }
                }
            }
        }

        int maxDist = Arrays.stream(dist).skip(1).max().getAsInt();
        return maxDist == Integer.MAX_VALUE ? -1 : maxDist;
    }
}