class Solution {
    private int[][] dp;
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        dp = new int[n][amount+1];
        for(int[] d : dp) Arrays.fill(d, -1);

        int ans = rec(n - 1, amount, coins);
        return ans >= (int)1e9 ? -1 : ans;
    }

    private int rec(int i, int k, int[] coins) {
        if(i == 0) {
            if(k % coins[0] == 0) return k / coins[0];
            return (int)1e9;
        }

        if(dp[i][k] != -1) return dp[i][k];

        int notTake = rec(i - 1, k, coins);

        int take = (int)1e9;
        if(coins[i] <= k) {
            take = 1 + rec(i, k - coins[i], coins);
        }

        return dp[i][k] = Math.min(take, notTake);
    }
}