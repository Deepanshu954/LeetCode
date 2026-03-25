class Solution {
    public int findCircleNum(int[][] grid) {
        boolean[] vis = new boolean[grid.length];

        int res = 0;

        for(int i = 0; i < grid.length; i++) {
            if(!vis[i]) {
                dfs(grid, i, vis);
                res++;
            }
        }

        return res;
    }

    private void dfs(int[][] grid, int node, boolean[] vis) {
        vis[node] = true;

        for(int i = 0; i < grid.length; i++) {
            if(grid[node][i] == 1 && !vis[i]) {
                dfs(grid, i, vis);
            }
        }
    }
}