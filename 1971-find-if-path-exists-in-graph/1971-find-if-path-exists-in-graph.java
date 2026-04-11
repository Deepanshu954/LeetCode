class Solution {
    public boolean validPath(int n, int[][] edges, int src, int dest) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        boolean[] vis = new boolean[n];
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(src);
        vis[src] = true;

        while(!q.isEmpty()) {
            int node = q.poll();

            for(int nei : adj.get(node)) {

                if(!vis[nei]) {
                    q.offer(nei);
                    vis[nei] = true;
                }
            }
        }

        return vis[dest];
    }
}