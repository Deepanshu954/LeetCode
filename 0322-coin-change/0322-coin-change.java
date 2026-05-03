class Solution {
    public int coinChange(int[] coins, int amount) {
        int ans = rec(coins.length - 1, amount, coins);
        return ans >= (int)1e9 ? -1 : ans;
    }

    private int rec(int i, int k, int[] coins) {
        if(i == 0) {
            if(k % coins[0] == 0) return k / coins[0];
            return (int)1e9;
        }

        int notTake = rec(i - 1, k, coins);

        int take = (int)1e9;
        if(coins[i] <= k) {
            take = 1 + rec(i, k - coins[i], coins);
        }

        return Math.min(take, notTake);
    }
}