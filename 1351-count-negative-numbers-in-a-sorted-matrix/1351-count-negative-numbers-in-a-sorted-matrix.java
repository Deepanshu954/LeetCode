class Solution {
    public int countNegatives(int[][] grid) {
        int c = 0, row = grid.length - 1, col = grid[row].length - 1, i = 0, j = col;

        while(i <= row && j >= 0) {
            int mid = grid[i][j];

            if(mid < 0) {
                j--;
                c += (row - i+1);
            } else i++;
        }

        return c;
    }
}