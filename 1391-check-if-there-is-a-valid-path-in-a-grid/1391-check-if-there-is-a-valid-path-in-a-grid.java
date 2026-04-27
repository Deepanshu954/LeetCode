import java.util.*;

class Solution {
    // Street connections for each type (1-6)
    // dirs[i] = { {dr1, dc1}, {dr2, dc2} }
    private int[][][] dirs = {
        {{0, -1}, {0, 1}},  // Type 1: left, right
        {{-1, 0}, {1, 0}},  // Type 2: upper, lower
        {{0, -1}, {1, 0}},  // Type 3: left, lower
        {{0, 1}, {1, 0}},   // Type 4: right, lower
        {{0, -1}, {-1, 0}}, // Type 5: left, upper
        {{0, 1}, {-1, 0}}   // Type 6: right, upper
    };

    public boolean hasValidPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0], c = curr[1];
            if (r == m - 1 && c == n - 1) return true;

            int streetType = grid[r][c] - 1; // 0-indexed for dirs array
            for (int[] dir : dirs[streetType]) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                // Check boundaries and if already visited
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc]) {
                    // Check if the neighbor can connect back to current cell
                    if (canConnectBack(grid[nr][nc], nr, nc, r, c)) {
                        visited[nr][nc] = true;
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }
        }
        return false;
    }

    private boolean canConnectBack(int neighborType, int nr, int nc, int targetR, int targetC) {
        for (int[] dir : dirs[neighborType - 1]) {
            if (nr + dir[0] == targetR && nc + dir[1] == targetC) {
                return true;
            }
        }
        return false;
    }
}