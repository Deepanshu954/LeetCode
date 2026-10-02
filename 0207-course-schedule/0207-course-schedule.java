class Solution {

    public boolean canFinish(int V, int[][] edges) {
        List<Integer>[] adj = new ArrayList[V];

        for(int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj[u].add(v);
            //. adj[ edge[0] ].add[ edge[1] ];
        }

        int[] state = new int[V];
        for(int i = 0; i < V; i++) {
            if(dfs(i, adj, state)) return false;
        }

        return true;
    }

    private boolean dfs(int node, List<Integer>[] adj, int[] state) {
        if(state[node] == 1) return true; // cycle
        if(state[node] == 2) return false; // already reached

        state[node] = 1;

        for(int nei : adj[node]) {
            if(dfs(nei, adj, state)) return true;
        }

        state[node] = 2;

        return false;
    }
}