class Solution {
    public void solveSudoku(char[][] board) {
        if(solve(board)) return;
    }

    private boolean solve(char[][] board) {
        int row = -1;
        int col = -1;

        boolean foundEmpty = true;

        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] == '.') {
                    row = i;
                    col = j;
                    foundEmpty = false;
                    break;
                }
            }
            if(!foundEmpty) break;
        }

        if(foundEmpty) return true;

        for(char num = '1'; num <= '9'; num++) {
            if(isValid(num, board, row, col)) {
                board[row][col] = num;
                if(solve(board)) return true;
                board[row][col] = '.';
            }
        }

        return false;
        
    }

    private boolean isValid(char num, char[][] board, int row, int col) {
        // check row
        for(int i = 0; i < 9; i++) {
            if(board[row][i] == num) return false;
            if(board[i][col] == num) return false;
        }

        // check grid
        int x = row - row % 3;
        int y = col - col % 3;

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(board[x+i][y+j] == num) return false;
            }
        }
        return true;

    }
}