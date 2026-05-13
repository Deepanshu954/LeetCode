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