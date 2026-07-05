// memorization

import java.util.List;

class Solution {
    private int mod = 1000000007;
    
    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        int m = board.get(0).length();
        int[][][] memo = new int[n][m][2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                memo[i][j][0] = -1;
                memo[i][j][1] = -1;
            }
        }

        int[] result = helper(n - 1, m - 1, board, memo);
        
        if (result[0] == -1) {
            return new int[]{0, 0};
        }
        return result;
    }

    private int[] helper(int row, int col, List<String> board, int[][][] memo) {
        if (row == 0 && col == 0) {
            return new int[]{0, 1};
        }

        if (memo[row][col][0] != -1) {
            return memo[row][col];
        }

        int maxScore = -1;
        int paths = 0;

        if (row > 0 && board.get(row - 1).charAt(col) != 'X') {
            int[] up = helper(row - 1, col, board, memo);

            if (up[0] != -1) {
                char c = board.get(row - 1).charAt(col);
                int val = (c == 'E') ? 0 : c - '0';

                if (up[0] + val > maxScore) {
                    maxScore = up[0] + val;
                    paths = up[1];
                } else if (up[0] + val == maxScore) {
                    paths = (paths + up[1]) % mod;
                }
            }
        }

        if (col > 0 && board.get(row).charAt(col - 1) != 'X') {
            int[] left = helper(row, col - 1, board, memo);

            if (left[0] != -1) {
                char c = board.get(row).charAt(col - 1);
                int val = (c == 'E') ? 0 : c - '0';

                if (left[0] + val > maxScore) {
                    maxScore = left[0] + val;
                    paths = left[1];
                } else if (left[0] + val == maxScore) {
                    paths = (paths + left[1]) % mod;
                }
            }
        }

        if (row > 0 && col > 0 && board.get(row - 1).charAt(col - 1) != 'X') {
            int[] diag = helper(row - 1, col - 1, board, memo);

            if (diag[0] != -1) {
                char c = board.get(row - 1).charAt(col - 1);
                int val = (c == 'E') ? 0 : c - '0';
                
                if (diag[0] + val > maxScore) {
                    maxScore = diag[0] + val;
                    paths = diag[1];
                } else if (diag[0] + val == maxScore) {
                    paths = (paths + diag[1]) % mod;
                }
            }
        }

        memo[row][col][0] = maxScore;
        memo[row][col][1] = paths;
        return memo[row][col];
    }
}

/*
// Recursion

class Solution {
    private int res = 0;
    private int cnt = 0;
    private int mod = 1000000007;
    
    public int[] pathsWithMaxScore(List<String> board) {
        int m = board.get(0).length() - 1;
        int n = board.size() - 1;

        helper(n, m, 0, board);
        return new int[] {res, cnt};
    }

    private void helper(int row, int col, int sum, List<String> board) {
        if(row == 0 && col == 0) {
            if(sum > res) {
                res = sum;
                cnt = 0;
            }

            if(res == sum) {
                cnt = (cnt + 1) % mod;
            }
            return;
        }

        if(row > 0 && board.get(row-1).charAt(col) != 'X') {
            char c = board.get(row-1).charAt(col);
            int val = (c == 'E') ? 0 : c - '0';

            helper(row - 1, col, sum + val, board);
        }

        if(col > 0 && board.get(row).charAt(col-1) != 'X') {
            char c = board.get(row).charAt(col-1);
            int val = (c == 'E') ? 0 : c - '0';

            helper(row, col - 1, sum + val, board);
        }

        if(row > 0 && col > 0 && board.get(row-1).charAt(col-1) != 'X') {
            char c = board.get(row-1).charAt(col-1);
            int val = (c == 'E') ? 0 : c - '0';

            helper(row - 1, col - 1, sum + val, board);
        }
    } 
}

*/