/*

// Recursion

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        int o = s3.length();

        if(m + n != o) return false;

        return rec(m-1, n-1, o-1, s1, s2, s3);
    }

    private boolean rec(int i, int j, int k, String s1, String s2, String s3) {
        if(i < 0 && j < 0) return true;

        char ch1 = (i >= 0) ? s1.charAt(i) : 'X';
        char ch2 = (j >= 0) ? s2.charAt(j) : 'X';
        char ch3 = s3.charAt(k);

        if(ch1 == ch2 && ch1 == ch3) {
            return rec(i-1, j, k-1, s1, s2, s3) || rec(i, j-1, k-1, s1, s2, s3);
        } else if(ch1 == ch3) {
            return rec(i-1, j, k-1, s1, s2, s3);
        } else if(ch2 == ch3) {
            return rec(i, j-1, k-1, s1, s2, s3);
        } else {
            return false;
        }
    }
}


*/

class Solution {
    private Boolean[][] dp;
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        int o = s3.length();

        if(m + n != o) return false;

        dp = new Boolean[m+1][n+1];

        return rec(m-1, n-1, o-1, s1, s2, s3);
    }

    private boolean rec(int i, int j, int k, String s1, String s2, String s3) {
        if(i < 0 && j < 0) return true;

        if(i >= 0 && j >= 0 && dp[i][j] != null) return dp[i][j];

        char ch1 = (i >= 0) ? s1.charAt(i) : 'X';
        char ch2 = (j >= 0) ? s2.charAt(j) : 'X';
        char ch3 = s3.charAt(k);

        boolean res = false;

        if(ch1 == ch3) {
            res |= rec(i-1, j, k-1, s1, s2, s3);
        } 
        if(ch2 == ch3) {
            res |= rec(i, j-1, k-1, s1, s2, s3);
        }

        if(i >= 0 && j >= 0) dp[i][j] = res;

        return res;
    }
}
