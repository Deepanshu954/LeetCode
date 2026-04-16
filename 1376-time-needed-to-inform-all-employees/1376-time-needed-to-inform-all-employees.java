class Solution {
    public int numOfMinutes(int n, int node, int[] manager, int[] info) {
        List<Integer>[] adj = new ArrayList[n];
        for(int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            if(manager[i] != -1) adj[manager[i]].add(i);
        }

        return dfs(node, adj, info);
    }

    private int dfs(int node, List<Integer>[] adj, int[] info) {
        int max = 0;

        for(int child : adj[node]) {
            max = Math.max(max, dfs(child, adj, info));
        }

        return info[node] + max;
    }
}