// Memorization

class Solution {
    private Boolean[][] dp;

    public boolean isMatch(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        dp = new Boolean[m][n];
        return rec(m-1, n-1, s1, s2);
    }

    private boolean rec(int i, int j, String s1, String s2) {

        if(i < 0 && j < 0) return true;
        if(j < 0) return false;

        if(i < 0) {
            for(int k = 0; k <= j; k++) {
                if(s2.charAt(k) != '*') return false;
            }
            return true;
        }

        if(dp[i][j] != null) return dp[i][j];

        char ch1 = s1.charAt(i);
        char ch2 = s2.charAt(j);

        if(ch1 == ch2 || ch2 == '?') {
            return dp[i][j] = rec(i-1, j-1, s1, s2);
        }
        else if(ch2 == '*') {
            return dp[i][j] = rec(i-1, j, s1, s2) || rec(i, j-1, s1, s2);
        }

        return dp[i][j] = false;
    }
}


/*

// Recursion

class Solution {
    public boolean isMatch(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        return rec(m-1, n-1, s1, s2);
    }

    private boolean rec(int i, int j, String s1, String s2) {
        if(i < 0 && j < 0) return true;
        if(j < 0) return false;

        if(i < 0) {
            for(int k = 0; k <= j; k++) {
                if(s2.charAt(k) != '*') return false;
            }
            return true;
        }

        char ch1 = s1.charAt(i);
        char ch2 = s2.charAt(j);

        if(ch1 == ch2 || ch2 == '?') return rec(i-1, j-1, s1, s2);

        if(ch2 == '*') return rec(i-1, j, s1, s2) || rec(i, j-1, s1, s2);

        return false;
    }
}

*/