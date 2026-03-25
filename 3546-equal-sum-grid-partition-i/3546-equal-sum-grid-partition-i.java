class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        long total = 0;

        long[] row = new long[m];

        // Calculate total + row sums
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                total += grid[i][j];
                row[i] += grid[i][j];
            }
        }

        if (total % 2 != 0) return false;
        long target = total / 2;

        // Check horizontal cut
        long sum = 0;
        for (int i = 0; i < m - 1; i++) {
            sum += row[i];
            if (sum == target) return true;
        }

        // Check vertical cut (compute on the fly)
        for (int j = 0; j < n - 1; j++) {
            long colSum = 0;
            for (int i = 0; i < m; i++) {
                colSum += grid[i][j];
            }
            sum += colSum;
            if (sum == target) return true;
        }

        return false;
    }
}