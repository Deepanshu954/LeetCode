class Solution {
  public void setZeroes(int[][] mat) {
    int m = mat.length;
    int n = mat[0].length;

    boolean flagR = false;
    boolean flagC = false;

    // Mark Row
    for(int i = 0; i < m; i++) {
      if(mat[i][0] == 0) flagC = true;
    }

    // Mark Col
    for(int j = 0; j < n; j++) {
      if(mat[0][j] == 0) flagR = true;
    }

    // Use Markers
    for(int i = 1; i < m; i++) {
      for(int j = 1; j < n; j++) {
        if(mat[i][j] == 0) {
            mat[i][0] = 0;
            mat[0][j] = 0;
        }
      }
    }

    // Set Zero Based On Marker
    for(int i = 1; i < m; i++) {
      for(int j = 1; j < n; j++) {
        if(mat[i][0] == 0 || mat[0][j] == 0) {
          mat[i][j] = 0;
        }
      }
    }

    if(flagC) {
      for(int i = 0; i < m; i++) mat[i][0] = 0;
    }

    if(flagR) {
      for(int j = 0; j < n; j++) mat[0][j] = 0;
    }

  }
}