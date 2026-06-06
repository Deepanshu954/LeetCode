class Solution {
    public void setZeroes(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        boolean col0 = false;

        // Mark Row And Col
        for(int i = 0; i < m; i++) {
            if(mat[i][0] == 0) col0 = true;

            for(int j = 1; j < n; j++) {
                if(mat[i][j] == 0) {
                    mat[i][0] = 0;
                    mat[0][j] = 0;
                }
            }
        }

        // Apply marker
        for(int i = m-1; i >= 0; i--) {
            for(int j = n-1; j >= 1; j--) {
                if(mat[i][0] == 0 || mat[0][j] == 0) {
                    mat[i][j] = 0;
                }
            }

            if(col0) mat[i][0] = 0;
        }


    }
}