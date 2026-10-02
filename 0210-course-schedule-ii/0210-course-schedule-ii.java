class Solution {
    public int[] findOrder(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // indegree
        int[] indegree = new int[V];

        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(v).add(u);
            indegree[u]++;
        }




        Queue<Integer> q = new ArrayDeque<>();
        int cnt = 0;

        for(int i = 0; i < V; i++) {
            if(indegree[i] == 0) q.offer(i);
        }

        int[] res = new int[V];
        int idx = 0;

        while(!q.isEmpty()) {
            int node = q.poll();
            res[idx++] = node;
            cnt++;

            for(int nei : adj.get(node)) {
                if(--indegree[nei] == 0) q.offer(nei); 
            }
        }

        if(cnt != V) return new int[]{};

        return res;

    }
}