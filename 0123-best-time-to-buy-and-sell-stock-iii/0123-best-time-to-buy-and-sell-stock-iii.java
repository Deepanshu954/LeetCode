class Solution {
    private Integer[][][] dp;
    public int maxProfit(int[] prices) {
        int n = prices.length;
        dp = new Integer[n+1][3][2];

        return rec(n-1, 2, 0, prices);
    }

    private int rec(int i, int j, int k, int[] prices) {
        if(i == 0)
            return (k == 0) ? 0 : -prices[0];
        if(j == 0) return 0;

        if(dp[i][j][k] != null) return dp[i][j][k];

        if(k == 0) {
            dp[i][j][k] = Math.max(
                rec(i-1, j, 0, prices),
                rec(i-1, j, 1, prices) + prices[i]
            );
        } else {
            dp[i][j][k] = Math.max(
                rec(i-1, j, 1, prices),
                rec(i-1, j-1, 0, prices) - prices[i]
            );
        }

        return dp[i][j][k];
    }
}