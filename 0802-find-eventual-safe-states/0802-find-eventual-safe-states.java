class Solution {
    // terminal node -> no outgoing edges
    // safe node -> every path from there end's at a terminal node
    // return all the safe node
    // sort the result

    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList<>();

        // reverse graph
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < graph.length; i++) {
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[graph.length];
        for(int u = 0; u < graph.length; u++) {
            for(int v : graph[u]) {
                adj.get(v).add(u);
                indegree[u]++;
            }
        }

        // queue
        Queue<Integer> q = new ArrayDeque<>();

        for(int i = 0; i < graph.length; i++) {
            if(indegree[i] == 0) q.offer(i);
        }

        while(!q.isEmpty()) {
            int node = q.poll();
            res.add(node);

            for(int nei : adj.get(node)) {
                if(--indegree[nei] == 0) q.offer(nei);
            }
        }

        Collections.sort(res);

        return res;
    }
}