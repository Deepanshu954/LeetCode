class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();

        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {

            // left → right
            for (int col = left; col <= right; col++)
                list.add(matrix[top][col]);
            top++;

            // top → bottom
            for (int row = top; row <= bottom; row++)
                list.add(matrix[row][right]);
            right--;

            if (top <= bottom) {
                // right → left
                for (int col = right; col >= left; col--)
                    list.add(matrix[bottom][col]);
                bottom--;
            }

            if (left <= right) {
                // bottom → top
                for (int row = bottom; row >= top; row--)
                    list.add(matrix[row][left]);
                left++;
            }
        }
        return list;
    }
}