// memorization

class Solution {
    private int[][] dp;
    public int minDistance(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        dp = new int[m+1][n+1];
        for(int[] d : dp) Arrays.fill(d, -1);

        return rec(m-1, n-1, s1, s2);
    }

    private int rec(int i, int j, String s1, String s2) {
        if(i < 0) return j+1; // insert all
        if(j < 0) return i+1; // delete all

        if(dp[i][j] != -1) return dp[i][j];

        if(s1.charAt(i) == s2.charAt(j)) {
            return rec(i-1, j-1, s1, s2);
        }

        int del = rec(i-1, j, s1, s2);
        int ins = rec(i, j-1, s1, s2);
        int rep = rec(i-1, j-1, s1, s2);

        return dp[i][j] = 1 + Math.min(del, Math.min(ins,rep));
    }
}

/*

// recursion

class Solution {
    public int minDistance(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        return rec(m-1, n-1, s1, s2);
    }

    private int rec(int i, int j, String s1, String s2) {
        if(i < 0) return j+1; // insert all
        if(j < 0) return i+1; // delete all

        if(s1.charAt(i) == s2.charAt(j)) {
            return rec(i-1, j-1, s1, s2);
        }

        int del = rec(i-1, j, s1, s2);
        int ins = rec(i, j-1, s1, s2);
        int rep = rec(i-1, j-1, s1, s2);

        return 1 + Math.min(del, Math.min(ins,rep));
    }
}

*/