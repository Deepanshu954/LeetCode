class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;

        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());

        int[] indegree = new int[n];

        // reverse graph + build indegree
        for(int i = 0; i < n; i++) {
            for(int v : graph[i]) {
                adj.get(v).add(i); // reverse edge
                indegree[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            if(indegree[i] == 0) q.offer(i);
        }

        boolean[] safe = new boolean[n];

        while(!q.isEmpty()) {
            int node = q.poll();
            safe[node] = true;

            for(int nei : adj.get(node)) {
                if(--indegree[nei] == 0) {
                    q.offer(nei);
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(safe[i]) res.add(i);
        }

        return res;
    }
}