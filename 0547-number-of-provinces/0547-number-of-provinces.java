class Solution {
    public int findCircleNum(int[][] graph) {
        boolean[] vis = new boolean[graph.length];

        int prov = 0;

        for(int i = 0; i < graph.length; i++) {
            if(!vis[i]) {
                dfs(graph, i, vis);
                prov++;
            }
        }

        return prov;
    }

    private void dfs(int[][] graph, int node, boolean[] vis) {
        vis[node] = true;

        for(int i = 0; i < graph.length; i++) {
            if(graph[node][i] == 1 && !vis[i]) {
                dfs(graph, i, vis);
            }
        }
    }
}