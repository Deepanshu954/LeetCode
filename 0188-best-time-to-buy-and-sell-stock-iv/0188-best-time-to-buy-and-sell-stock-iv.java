class Solution {
    private Integer[][][] dp;

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;

        // optimization
        if (k >= n / 2) {
            int profit = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1])
                    profit += prices[i] - prices[i - 1];
            }
            return profit;
        }

        dp = new Integer[n][k + 1][2];
        return rec(n - 1, k, 0, prices);
    }

    private int rec(int i, int j, int hold, int[] prices) {
        if (i == 0) {
            return (hold == 0) ? 0 : -prices[0];
        }

        if (j == 0) {
            return (hold == 0) ? 0 : Integer.MIN_VALUE / 2;
        }

        if (dp[i][j][hold] != null) return dp[i][j][hold];

        if (hold == 0) {
            dp[i][j][hold] = Math.max(
                rec(i - 1, j, 0, prices),
                rec(i - 1, j, 1, prices) + prices[i]
            );
        } else {
            dp[i][j][hold] = Math.max(
                rec(i - 1, j, 1, prices),
                rec(i - 1, j - 1, 0, prices) - prices[i]
            );
        }

        return dp[i][j][hold];
    }
}