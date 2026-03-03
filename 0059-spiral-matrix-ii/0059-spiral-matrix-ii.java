class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        



        int top = 0, bottom = n - 1;
        int left = 0, right = n - 1;

        int index = 1;

        while (top <= bottom && left <= right) {

            // left → right
            for (int col = left; col <= right; col++)
                matrix[top][col] = index++;
            top++;

            // top → bottom
            for (int row = top; row <= bottom; row++)
                matrix[row][right] = index++;
            right--;

            if (top <= bottom) {
                // right → left
                for (int col = right; col >= left; col--)
                    matrix[bottom][col] = index++;
                bottom--;
            }

            if (left <= right) {
                // bottom → top
                for (int row = bottom; row >= top; row--)
                    matrix[row][left] = index++;
                left++;
            }
        }
        return matrix;
    }
}