class Solution {
    public int minDistance(String s1, String s2) {
        int com = lcs(s1, s2);

        return s1.length() + s2.length() - (2 * com);
    }

    private int lcs(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[] dp = new int[m+1];

        for(int i = 1; i <= n; i++) {
            char ch1 = s1.charAt(i-1);

            int[] curr = new int[m+1];

            for(int j = 1; j <= m; j++) {
                char ch2 = s2.charAt(j-1);

                if(ch1 == ch2) curr[j] = 1 + dp[j-1];
                else curr[j] = Math.max(dp[j], curr[j-1]);
            }

            dp = curr;
        }

        return dp[m];
    }
}
