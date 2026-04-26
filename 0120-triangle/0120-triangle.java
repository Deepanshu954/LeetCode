class Solution {
    public int minimumTotal(List<List<Integer>> tri) {
        int n = tri.size();
        int[][] dp = new int[n][n];

        // Base Case
        dp[0][0] = tri.get(0).get(0);

        // recursive part
        for(int i = 1; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                int val = tri.get(i).get(j);

                if(j == 0) {
                    dp[i][j] = val + dp[i-1][j];
                } else if(j == i) {
                    dp[i][j] = val + dp[i-1][j-1];
                } else {
                    dp[i][j] = val + Math.min(dp[i-1][j], dp[i-1][j-1]);
                }
            }
        }

        int res = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++) {
            res = Math.min(res, dp[n-1][i]);
        }

        return res;
    }
}


/*

// Memorization

class Solution {
    private int[][] dp;
    public int minimumTotal(List<List<Integer>> tri) {
        int n = tri.size();
        dp = new int[n][n];
        for(int[] d : dp) Arrays.fill(d, -1);

        int minPath = Integer.MAX_VALUE;

        for(int c = 0; c < n; c++) {
            minPath = Math.min(minPath, rec(n-1, c, tri));
        }
        return minPath;
    }

    private int rec(int r, int c, List<List<Integer>> tri) {
        if(r == 0) return tri.get(0).get(0);
        if(c < 0 || c > r) return (int)1e9;
        if(dp[r][c] != -1) return dp[r][c];

        dp[r][c] = tri.get(r).get(c) + Math.min(rec(r-1, c, tri), rec(r-1, c-1, tri));
        return dp[r][c];
    }
}

*/