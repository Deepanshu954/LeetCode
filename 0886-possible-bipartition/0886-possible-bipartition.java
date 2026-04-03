class Solution {
    public boolean possibleBipartition(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        int[] color = new int[n+1];
        color[0] = 2;

        for(int i = 1; i <= n; i++) {
            if(color[i] != 0) continue;

            Queue<Integer> q = new ArrayDeque<>();
            q.offer(i);
            color[i] = 1;

            while(!q.isEmpty()) {
                int node = q.poll();

                for(int nei : adj.get(node)) {
                    if(color[nei] == 0) {
                        color[nei] = -color[node];
                        q.offer(nei);
                    } else if(color[node] == color[nei]) return false;
                }
            }
        }

        return true;
    }
}