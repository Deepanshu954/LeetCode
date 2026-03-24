class Solution {
    public void solveSudoku(char[][] board) {
        if( solve(board) ) return;
    }

    private boolean solve(char[][] board) {
        int row = -1;
        int col = -1;

        boolean empty = true;

        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] == '.') {
                    row = i;
                    col = j;
                    empty = false;
                    break;
                }
            }
            if(!empty) break;
        }

        if(empty) return true;

        for(char i = '1'; i <= '9'; i++) {
            if(isSafe(board, row, col, i)) {
                board[row][col] = i;
                if(solve(board)) return true;
                board[row][col] = '.';
            }
        }

        return false;
    }

    private boolean isSafe(char[][] board, int row, int col, char val) {
        // row Check
        for(int i = 0; i < 9; i++) {
            if(board[i][col] == val) return false;
        }

        // col check
        for(int i = 0; i < 9; i++) {
            if(board[row][i] == val) return false;
        }

        // 3 x 3 grid check
        int r = row - row % 3;
        int c = col - col % 3;

        // for(int i = 0; i < 3; i++) {
        //     for(int j = 0; j < 3; j++) {
        //         if(board[r + i][c + j] == val) return false;
        //     }
        // }

        for(int i = r; i < r + 3; i++) {
            for(int j = c; j < c + 3; j++) {
                if(board[i][j] == val) return false;
            }
        }

        return true;
    }
}