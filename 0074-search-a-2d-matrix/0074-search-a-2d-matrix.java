class Solution {
    public boolean searchMatrix(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;

        int low = 0;
        int high = m * n - 1;

        while(low <= high) {
            int mid = low + (high - low)/2;

            int row = mid / n;
            int col = mid % n;

            if(mat[row][col] == k) return true;

            if(mat[row][col] > k) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return false;
    }
}