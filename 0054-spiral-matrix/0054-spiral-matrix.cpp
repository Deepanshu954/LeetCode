class Solution {
public:
    vector<int> spiralOrder(vector<vector<int>>& matrix) 
    {
        int rows = matrix.size();
        int cols = matrix.empty() ? 0 : matrix[0].size();

        int firstRow = 0, lastRow = rows - 1;
        int firstCol = 0, lastCol = cols - 1;

        vector<int> arr;

        while (firstRow <= lastRow && firstCol <= lastCol)
        {
            // Left to right on the top row
            for (int j = firstCol; j <= lastCol; j++) {
                arr.push_back(matrix[firstRow][j]);
            }
            firstRow++;

            // Top to bottom on the rightmost column
            for (int i = firstRow; i <= lastRow; i++) {
                arr.push_back(matrix[i][lastCol]);
            }
            lastCol--;

            // Right to left on the bottom row
            if (firstRow <= lastRow) {
                for (int j = lastCol; j >= firstCol; j--) {
                    arr.push_back(matrix[lastRow][j]);
                }
                lastRow--;
            }

            // Bottom to top on the leftmost column
            if (firstCol <= lastCol) {
                for (int i = lastRow; i >= firstRow; i--) {
                    arr.push_back(matrix[i][firstCol]);
                }
                firstCol++;
            }
        }

        return arr;
    }
};