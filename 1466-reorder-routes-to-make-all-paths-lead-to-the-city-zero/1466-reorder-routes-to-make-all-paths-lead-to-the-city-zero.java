class Solution {
    public int minReorder(int n, int[][] connections) {
        List<int[]>[] adj = new ArrayList[n];

        for(int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int[] e : connections) {
            adj[e[0]].add(new int[]{e[1], 1});
            adj[e[1]].add(new int[]{e[0], 0});
        }

        boolean[] vis = new boolean[n];
        return dfs(0, adj, vis);
    }

    private int dfs(int u, List<int[]>[] adj, boolean[] vis) {
        vis[u] = true;
        int count = 0;

        for(int[] nei : adj[u]) {
            int v = nei[0];
            int w = nei[1];

            if(!vis[v]) 
                count += w + dfs(v, adj, vis);
        }

        return count;
    }
}