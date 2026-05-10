class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if(n == 1) return s;
        boolean[][] dp = new boolean[n][n];

        int start = 0;
        int maxLen = 0;

        for(int i = 0; i < n; i++) dp[i][i] = true;


        for(int i = n-1; i >= 0; i--) {
            for(int j = i+1; j < n; j++) {

                if(s.charAt(i) == s.charAt(j)) {
                    if(j-1 == 1 || dp[i+1][j-1]) {
                        dp[i][j] = true;

                        if(j - i + 1 > maxLen) {
                            maxLen = j-1+1;
                            start = i;
                        }
                    }
                }
            }
        }

        return s.substring(start, start + maxLen);
    }
}