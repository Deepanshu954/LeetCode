class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        return rec(n-1, 2, 0, prices);
    }

    private int rec(int i, int j, int k, int[] prices) {
        if(i == 0) {
            return (k == 0) ? 0 : -prices[0];
        }
        if(j == 0) {
            return 0;
        }

        if(k == 0) {
            return Math.max(
                rec(i-1, j, 0, prices),
                rec(i-1, j, 1, prices) + prices[i]
            );
        } else {
            return Math.max(
                rec(i-1, j, 1, prices),
                rec(i-1, j-1, 0, prices) - prices[i]
            );
        }
    }
}