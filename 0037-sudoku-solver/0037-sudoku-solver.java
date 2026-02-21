class Solution {
    public void solveSudoku(char[][] board) {
        if(solve( board)) return;
    }

    public boolean solve(char[][] board) {
        int row = -1;
        int col = -1;

        // Checking Does any postion is empty or not
        boolean emptyLeft = true;

        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] == '.') {
                    row = i;
                    col = j;
                    emptyLeft = false;
                    break;
                }
            }

            if(!emptyLeft) break;
        }

        // if there is no empty place reamin then return
        if(emptyLeft) return true;;

        for(char i = '1'; i <= '9'; i++) {
            if(isSafe(board, row, col, i)) {
                board[row][col] = i;
                if(solve(board)) return true;
                else board[row][col] = '.';
            }
        }
        
        return false;
    }

    private boolean isSafe(char[][] board, int row, int col, char num) {

        // checking row
        for(int i = 0; i < 9; i++) {
            if(board[i][col] == num) return false;
        }

        // checking col
        for(int i = 0; i < 9; i++) {
            if(board[row][i] == num) return false;
        }

        // Checking sub-box
        int r = row - row % 3;
        int c = col - col % 3;

        for(int i = r; i < r + 3; i++) {
            for(int j = c; j < c + 3; j++) {
                if(board[i][j] == num) return false;
            }
        }

        return true;
    }
}