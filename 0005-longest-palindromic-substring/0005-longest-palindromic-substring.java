class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();

        int[][] dp = new int[n][n];

        for(int i = 0; i < n; i++) dp[i][i] = 1;

        for(int i = n-1; i >= 0; i--) {
            for(int j = i+1; j < n; j++) {

                if(s.charAt(i) == s.charAt(j)) dp[i][j] = 2 + dp[i+1][j-1];
                else dp[i][j] = 0;
            }
        }

        int max = 0;
        int idx = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(max < dp[i][j]) {
                    max = dp[i][j];
                    idx = j;
                }
            }
        }

        String res = "" + max + "  -  " + idx;

        String ans = s.substring(idx - max + 1,idx+1);

        return ans;
    }
}