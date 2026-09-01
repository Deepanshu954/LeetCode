import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

class Solution {
    private static final int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();

        int startR = -1;
        int startC = -1;
        int[][] litterId = new int[m][n];
        for (int[] row : litterId) {
            Arrays.fill(row, -1);
        }

        int litterCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char ch = classroom[i].charAt(j);
                if (ch == 'S') {
                    startR = i;
                    startC = j;
                } else if (ch == 'L') {
                    litterId[i][j] = litterCount++;
                }
            }
        }

        int targetMask = (1 << litterCount) - 1;
        if (targetMask == 0) {
            return 0;
        }

        // maxEnergy[r][c][mask] stores the highest remaining energy seen at (r, c, mask)
        int[][][] maxEnergy = new int[m][n][1 << litterCount];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(maxEnergy[i][j], -1);
            }
        }

        // Bit-pack state: (r << 21) | (c << 16) | (mask << 6) | curEnergy
        Queue<Integer> queue = new ArrayDeque<>();
        maxEnergy[startR][startC][0] = energy;
        queue.offer(encode(startR, startC, 0, energy));

        int moves = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int state = queue.poll();
                int r = state >>> 21;
                int c = (state >>> 16) & 31;
                int mask = (state >>> 6) & 1023;
                int curEnergy = state & 63;

                if (curEnergy == 0) {
                    continue;
                }

                for (int[] dir : DIRS) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                        continue;
                    }

                    char ch = classroom[nr].charAt(nc);
                    if (ch == 'X') {
                        continue;
                    }

                    int nmask = mask;
                    if (ch == 'L') {
                        nmask |= (1 << litterId[nr][nc]);
                    }

                    // Check if all litter is collected upon reaching this cell
                    if (nmask == targetMask) {
                        return moves + 1;
                    }

                    int nextEnergy = (ch == 'R') ? energy : curEnergy - 1;

                    // Only enqueue if the student can still move from here and energy is strictly better
                    if (nextEnergy > 0 && nextEnergy > maxEnergy[nr][nc][nmask]) {
                        maxEnergy[nr][nc][nmask] = nextEnergy;
                        queue.offer(encode(nr, nc, nmask, nextEnergy));
                    }
                }
            }
            moves++;
        }

        return -1;
    }

    private int encode(int r, int c, int mask, int energy) {
        return (r << 21) | (c << 16) | (mask << 6) | energy;
    }
}