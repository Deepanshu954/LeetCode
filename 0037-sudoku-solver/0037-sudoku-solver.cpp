class Solution {
private:
    bool isValid(vector<vector<char>>& board, int row, int col, char num) {
        // Check row
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == num)
                return false;
        }

        // Check column
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num)
                return false;
        }

        // Check 3x3 box
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == num)
                    return false;
            }
        }

        return true;
    }

    bool backtrack(vector<vector<char>>& board, int row, int col) {
        if (row == 9)
            return true;

        if (col == 9)
            return backtrack(board, row + 1, 0);

        if (board[row][col] != '.')
            return backtrack(board, row, col + 1);

        for (char num = '1'; num <= '9'; num++) {
            if (isValid(board, row, col, num)) {
                board[row][col] = num;

                if (backtrack(board, row, col + 1))
                    return true;

                board[row][col] = '.';
            }
        }

        return false;
    }

public:
    void solveSudoku(vector<vector<char>>& board) {
        backtrack(board, 0, 0);
    }
};