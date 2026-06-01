class Solution {
    public void setZeroes(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        HashSet<Integer> set_i = new HashSet<>();
        HashSet<Integer> set_j = new HashSet<>();

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(mat[i][j] == 0) {
                    set_i.add(i);
                    set_j.add(j);
                }
            }
        }

        // row
        for(int s : set_i) {
            for(int j = 0; j < n; j++) {
                mat[s][j] = 0;
            }
        }

        // col
        for(int i = 0; i < m; i++) {
            for(int s : set_j) {
                mat[i][s] = 0;
            }
        }

    }
}