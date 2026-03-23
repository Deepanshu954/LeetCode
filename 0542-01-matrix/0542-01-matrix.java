class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        Queue<int[]> q = new ArrayDeque<>();

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(mat[i][j] == 0) q.offer(new int[]{i,j});
                else mat[i][j] = -1; 
            }
        }

        int[][] dir = {
            { 1, 0},
            {-1, 0},
            { 0, 1},
            { 0,-1}
        };

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];

            for(int[] d: dir) {
                int nx = x + d[0];
                int ny = y + d[1];

                if(nx >= 0 && nx < m && ny >= 0 && ny < n && mat[nx][ny] == -1) {
                    mat[nx][ny] = mat[x][y] + 1;
                    q.offer(new int[]{nx, ny});
                }
            }
        }

        return mat;
    }
}