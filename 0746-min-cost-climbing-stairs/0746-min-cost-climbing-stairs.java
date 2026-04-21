class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;

        int a = cost[0];
        int b = cost[1];

        for(int i = 2; i < n; i++) {
            int c = cost[i] + Math.min(a, b);

            a = b;
            b = c;
        }

        return Math.min(a,b);
    }
}

/*

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

*/

/*

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];

        dp[0] = cost[0];
        dp[1] = cost[1];

        for(int i = 2; i < n; i++) {
            dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
        }

        return Math.min(dp[n-1], dp[n-2]);
    }
}

*/