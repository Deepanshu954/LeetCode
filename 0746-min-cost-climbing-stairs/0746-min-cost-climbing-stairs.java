class Solution {
    private int[] dp;
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        dp = new int[n];
        Arrays.fill(dp, -1);

        return Math.min(rec(n-1, cost), rec(n-2, cost));
    }

    private int rec(int n, int[] cost) {
        if(n < 2) return cost[n]; 
        if(dp[n] != -1) return dp[n];

        dp[n] = cost[n] + Math.min(
            rec(n-1, cost),
            rec(n-2, cost)
        );

        return dp[n];
    }
}