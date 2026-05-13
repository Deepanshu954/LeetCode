class Solution {
    private Integer[][] dp;
    public int maxProfit(int[] prices) {
        dp = new Integer[prices.length][2];
        return rec(0, 0, prices); // start with no stock
    }

    private int rec(int i, int hold, int[] prices) {
        if(i == prices.length) return 0;

        if(dp[i][hold] != null) return dp[i][hold];

        if(hold == 0) { // no stock → can BUY
            dp[i][hold] = Math.max(
                rec(i+1, 0, prices),              // skip
                rec(i+1, 1, prices) - prices[i]   // buy
            );
        } else { // hold == 1 → we have stock → can SELL
            dp[i][hold] = Math.max(
                rec(i+1, 1, prices),  // skip
                prices[i]             // sell → STOP (LC121)
            );
        }

        return dp[i][hold];
    }
}