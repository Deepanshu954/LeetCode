class Solution {
public:
    bool solve(vector<vector<char>>& board, int row, int col) {
        if (row == 9) return true;
        
        if (col == 9)
            return solve(board, row + 1, 0);
        
        if (board[row][col] != '.')
            return solve(board, row, col + 1);
        
        for (char num = '1'; num <= '9'; num++) {
            bool valid = true;
            
            // Check row
            for (int j = 0; j < 9; j++) {
                if (board[row][j] == num) {
                    valid = false;
                    break;
                }
            }
            
            // Check column
            for (int i = 0; i < 9 && valid; i++) {
                if (board[i][col] == num) {
                    valid = false;
                    break;
                }
            }
            
            // Check 3x3 box
            int sr = (row / 3) * 3;
            int sc = (col / 3) * 3;
            
            for (int i = sr; i < sr + 3 && valid; i++) {
                for (int j = sc; j < sc + 3; j++) {
                    if (board[i][j] == num) {
                        valid = false;
                        break;
                    }
                }
            }
            
            if (valid) {
                board[row][col] = num;
                
                if (solve(board, row, col + 1))
                    return true;
                
                board[row][col] = '.';
            }
        }
        
        return false;
    }

    void solveSudoku(vector<vector<char>>& board) {
        solve(board, 0, 0);
    }
};