class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();

        boolean[] vis = new boolean[n];

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(0);
        vis[0] = true;

        while(!q.isEmpty()) {
            int node = q.poll();

            for(int nei : rooms.get(node)) {
                if(!vis[nei]) {
                    vis[nei] = true;
                    q.offer(nei);
                }
            }
        }

        for(int i = 0; i < n; i++) {
            if(!vis[i]) return false;
        }

        return true;
    }
}