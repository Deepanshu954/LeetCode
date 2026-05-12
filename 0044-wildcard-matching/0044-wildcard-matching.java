// Memorization

class Solution {
    private Boolean[][] dp;
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        dp = new Boolean[m+1][n+1];

        return rec(m-1, n-1, s, p);
    }

    private boolean rec(int i, int j, String s, String p) {
        if(i < 0 && j < 0) return true;
        if(j < 0) return false;

        if(i < 0) {
            for(int k = 0; k <= j; k++) {
                if(p.charAt(k) != '*') return false;
            } return true;
        }

        if(dp[i][j] != null) return dp[i][j];

        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
            dp[i][j] = rec(i-1, j-1, s, p);
        } else if(p.charAt(j) == '*') {
            dp[i][j] =  rec(i, j-1, s, p) || rec(i-1, j, s, p);
        } else dp[i][j] = false;

        return dp[i][j];
    }
}

/*

// Recursion

class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        return rec(m-1, n-1, s, p);
    }

    private boolean rec(int i, int j, String s, String p) {
        if(i < 0 && j < 0) return true;
        if(j < 0) return false;

        if(i < 0) {
            for(int k = 0; k <= j; k++) {
                if(p.charAt(k) != '*') return false;
            } return true;
        }

        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
            return rec(i-1, j-1, s, p);
        } else if(p.charAt(j) == '*') {
            return  rec(i, j-1, s, p) || rec(i-1, j, s, p);
        } else return false;
    }
}

*/