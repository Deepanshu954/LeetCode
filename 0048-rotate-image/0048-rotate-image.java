class Solution {
    public void rotate(int[][] mat) {
        int n = mat.length;

        // Transpose
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }

        // Reverse each row
        for(int i = 0; i < n; i++) {
            int l = 0;
            int r = n-1;

            while(l < r) {
                int temp = mat[i][l];
                mat[i][l] = mat[i][r];
                mat[i][r] = temp;

                l++;
                r--;
            }
        }
    }
}

/*

Case 1
1   2   3
4   5   6
7   8   9

1   4   7
2   5   8
3   6   9

7   4   1
8   5   2
9   6   3


3   2   1
6   5   4
9   8   7

7   4   1
8   5   2
9   6   3

*/