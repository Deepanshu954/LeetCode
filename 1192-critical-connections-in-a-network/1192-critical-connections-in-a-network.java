import java.util.*;

class Solution {
    private int timer = 1;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<n; i++) graph.add(new ArrayList<>());
        for(List<Integer> it : connections) {
            int u = it.get(0), v = it.get(1);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        int[] low = new int[n];
        int[] time = new int[n];
        boolean[] visited = new boolean[n];
        List<List<Integer>> bridges = new ArrayList<>();
        
        dfs(0, -1, time, low, visited, graph, bridges);
        return bridges;
    }
    
    private void dfs(int node, int parent, int[] time, int[] low, boolean[] visited,
                     List<List<Integer>> graph, List<List<Integer>> bridges) {
        visited[node] = true;
        time[node] = low[node] = timer++;
        
        for(int nb : graph.get(node)) {
            if(nb == parent) continue;
            if(!visited[nb]) {
                dfs(nb, node, time, low, visited, graph, bridges);
                // Update low value based on child
                low[node] = Math.min(low[node], low[nb]);
                // Check if the edge is a bridge
                if(low[nb] > time[node]) {
                    bridges.add(Arrays.asList(nb, node));
                }
            } else {
                // Back-edge: update low based on neighbor's discovery time
                low[node] = Math.min(low[node], time[nb]);
            }
        }
    }
}