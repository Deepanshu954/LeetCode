// Tabular

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];

        for(int i = n-1; i >= 0; i--) {
            dp[i][0] = Math.max(
                dp[i+1][0],
                dp[i+1][1] - prices[i]
            );

            dp[i][1] = Math.max(
                dp[i+1][1],
                prices[i]
            );
        }

        return dp[0][0];
    }
}

/*


// Recursion

class Solution {
    public int maxProfit(int[] prices) {
        return rec(0, 1, prices);
    }

    private int rec(int i, int buy, int[] prices) {
        if(i == prices.length) return 0;

        if(buy == 1) {
            int take = -prices[i] + rec(i+1, 0, prices); // buy
            int skip = rec(i+1, 1, prices);              // skip
            return Math.max(take, skip);
        } else {
            int sell = prices[i];        // sell → STOP (no future recursion)
            int skip = rec(i+1, 0, prices);
            return Math.max(sell, skip);
        }
    }
}


*/


/*

// Memorization


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

*/
