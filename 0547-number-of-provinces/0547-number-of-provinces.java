class Solution {
    public int findCircleNum(int[][] grid) {
        boolean[] vis = new boolean[grid.length];
        int cnt = 0;

        for(int i = 0; i < grid.length; i++) {
            if(!vis[i]) {
                dfs(grid, i, vis);
                cnt++;
            }
        }

        return cnt;
    }

    private void dfs(int[][] grid, int node, boolean[] vis) {
        vis[node] = true;

        for(int i = 0; i < vis.length; i++) {
            if(grid[node][i] == 1 && !vis[i]) dfs(grid, i, vis);
        }
    }
}