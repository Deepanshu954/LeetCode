class Solution {
    public boolean canFinish(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < V; i++) adj.add(new ArrayList<>());
        
        for(int[] e : edges) {
            adj.get(e[1]).add(e[0]); // prerequisite → course
        }
        
        int[] ind = new int[V];
        for(int i = 0; i < V; i++) {
            for(int nei : adj.get(i)) ind[nei]++;
        }
        
        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < V; i++) {
            if(ind[i] == 0) q.offer(i);
        }
        
        int count = 0;
        
        while(!q.isEmpty()) {
            int node = q.poll();
            count++;
            
            for(int nei : adj.get(node)) {
                if(--ind[nei] == 0) q.offer(nei);
            }
        }
        
        return count == V; // all courses finished
    }
}