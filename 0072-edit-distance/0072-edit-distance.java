// Tabular

class Solution {
    public int minDistance(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m + 1][n + 1];

        // Base Case
        for(int i = 0; i <= m; i++) dp[i][0] = i;
        for(int j = 0; j <= n; j++) dp[0][j] = j;

        // Rest
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = 1 + Math.min(
                        dp[i-1][j-1], 
                        Math.min(
                            dp[i-1][j], 
                            dp[i][j-1]
                        )
                    );
                }
            }
        }


        return dp[m][n];
    }
}

/*


// Recursion

class Solution {
    public int minDistance(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        return rec(m-1, n-1, s1, s2);
    }

    private int rec(int i, int j, String s1, String s2) {
        if(i < 0) return j+1;
        if(j < 0) return i+1;

        if(s1.charAt(i) == s2.charAt(j)) {
            return rec(i-1, j-1, s1, s2);
        }

        int ins = rec(i-1, j, s1, s2);
        int del = rec(i, j-1, s1, s2);
        int rep = rec(i-1, j-1, s1, s2);

        return 1 + Math.min(ins, Math.min(del, rep));
    }


}

*/

/*

// memorization

class Solution {
    private int[][] dp;

    public int minDistance(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        dp = new int[m + 1][n + 1];
        for (int[] d : dp)
            Arrays.fill(d, -1);

        return rec(m - 1, n - 1, s1, s2);
    }

    private int rec(int i, int j, String s1, String s2) {
        if (i < 0)
            return j + 1;
        if (j < 0)
            return i + 1;

        if (dp[i][j] != -1)
            return dp[i][j];

        if (s1.charAt(i) == s2.charAt(j)) {
            dp[i][j] = rec(i - 1, j - 1, s1, s2);
        } else {
            int ins = rec(i - 1, j, s1, s2);
            int del = rec(i, j - 1, s1, s2);
            int rep = rec(i - 1, j - 1, s1, s2);

            dp[i][j] = 1 + Math.min(ins, Math.min(del, rep));
        }

        return dp[i][j];
    }

}


*/