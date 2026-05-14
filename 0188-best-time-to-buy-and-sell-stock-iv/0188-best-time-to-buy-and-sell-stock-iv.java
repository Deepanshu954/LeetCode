class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n + 1][k+1][2];

        // Base Case
        for(int j = 0; j <= k; j++) {
            dp[0][j][0] = 0;

            dp[0][j][1] = (j > 0) ? -prices[0] : (int)-1e5;
        }

        // Rest
        for(int i = 1; i < n; i++) {
            for(int j = 0; j <= k; j++) {
                
                // Not Holding
                dp[i][j][0] = Math.max( 
                    dp[i-1][j][0],
                    dp[i-1][j][1] + prices[i]
                );

                // Holding

                if (j > 0) {
                    dp[i][j][1] = Math.max( 
                        dp[i-1][j][1],
                        dp[i-1][j-1][0] - prices[i]
                    );
                } else {
                    dp[i][j][1] = dp[i-1][j][1];
                }

            }
        }

        return dp[n-1][k][0];
    }
}