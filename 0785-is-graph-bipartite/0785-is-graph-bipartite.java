class Solution {
    public boolean isBipartite(int[][] graph) {
        int V = graph.length;

        int[] color = new int[V];
        for(int i = 0; i < V; i++) {
            if(color[i] != 0) continue;

            Queue<Integer> q = new ArrayDeque<>();
            q.offer(i);
            color[i] = 1;

            while(!q.isEmpty()) {
                int node = q.poll();

                for(int nei : graph[node]) {
                    if(color[nei] == 0) {
                        color[nei] = -color[node];
                        q.offer(nei);
                    } else if(color[node] == color[nei]) return false;
                }
            }
        }

        return true;
    }
}