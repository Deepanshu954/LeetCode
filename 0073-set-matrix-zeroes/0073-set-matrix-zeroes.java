class Solution {
    public void setZeroes(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        Set<Integer> sr = new HashSet<>();
        Set<Integer> sc = new HashSet<>();

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(mat[i][j] == 0) {
                    sr.add(i);
                    sc.add(j);
                }
            }
        }

        for(int s : sr) {
            for(int j = 0; j < n; j++) {
                mat[s][j] = 0;
            }
        }

        for(int i = 0; i < m; i++) {
            for(int s : sc) {
                mat[i][s] = 0;
            }
        }
    }
}