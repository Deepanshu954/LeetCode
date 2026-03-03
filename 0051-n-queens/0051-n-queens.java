import java.util.*;

class Solution {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        boolean[][] board = new boolean[n][n];
        queens(board, 0, ans);
        return ans;
    }

    static void queens(boolean[][] board, int row, List<List<String>> ans) {
        if (row == board.length) {
            ans.add(build(board));
            return;
        }

        for (int col = 0; col < board.length; col++) {
            if (isSafeQ(board, row, col)) {
                board[row][col] = true;
                queens(board, row + 1, ans);
                board[row][col] = false;
            }
        }
    }

    private static boolean isSafeQ(boolean[][] board, int row, int col) {

        // Vertical check
        for (int i = 0; i < row; i++) {
            if (board[i][col]) return false;
        }

        // Left diagonal
        for (int i = 1; i <= Math.min(row, col); i++) {
            if (board[row - i][col - i]) return false;
        }

        // Right diagonal
        for (int i = 1; i <= Math.min(row, board.length - col - 1); i++) {
            if (board[row - i][col + i]) return false;
        }

        return true;
    }

    private static List<String> build(boolean[][] board) {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < board.length; j++) {
                sb.append(board[i][j] ? 'Q' : '.');
            }
            list.add(sb.toString());
        }

        return list;
    }
}