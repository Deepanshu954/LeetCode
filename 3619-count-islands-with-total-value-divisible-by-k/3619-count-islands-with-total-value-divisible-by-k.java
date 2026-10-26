import java.util.*;

class Solution {
    public int countIslands(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        int cnt = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0 && !visited[i][j]) {
                    if (bfs(grid, visited, i, j, k)) {
                        cnt++;
                    }
                }
            }
        }

        return cnt;
    }

    private boolean bfs(int[][] grid, boolean[][] visited,
                        int r, int c, int k) {
        int m = grid.length;
        int n = grid[0].length;

        long sum = 0;

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{r, c});
        visited[r][c] = true;

        int[][] dirs = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
        };

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];

            sum += grid[x][y];

            for (int[] d : dirs) {
                int nx = x + d[0];
                int ny = y + d[1];

                if (nx >= 0 && nx < m &&
                    ny >= 0 && ny < n &&
                    grid[nx][ny] != 0 &&
                    !visited[nx][ny]) {

                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }
        }

        return sum % k == 0;
    }
}