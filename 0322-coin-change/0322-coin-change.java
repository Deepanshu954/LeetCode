class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];

        // Base Case
        for(int j = 0; j <= amount; j++) {
            if(j % coins[0] == 0) dp[0][j] = j / coins[0];
            else dp[0][j] = (int)1e9;
        }


        // rest
        for(int i = 1; i < n; i++) {
            for(int j = 0; j <= amount; j++) {
                int notTake = dp[i-1][j];

                int take = (int)1e9;
                if(coins[i] <= j) 
                    take = 1 + dp[i][j - coins[i]];

                dp[i][j] = Math.min(take, notTake);
            }
        }

        return (dp[n-1][amount] >= (int)1e9) ? -1 : dp[n-1][amount];
    }
}

/*

// Recursion

public class Solution {
    public static int findWays(int num[], int tar) {
        int n = num.length;
        return rec(n - 1, tar, num);
    }

    private static int rec(int i, int k, int[] nums) {
        if (i == 0) {
            if (k == 0 && nums[0] == 0) return 2;
            if (k == 0) return 1;
            if (nums[0] == k) return 1;
            return 0;
        }

        int notTake = rec(i - 1, k, nums);

        int take = 0;
        if (nums[i] <= k) {
            take = rec(i - 1, k - nums[i], nums);
        }

        return take + notTake;
    }
}

*/


/*

// Memorization

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

*/

/*

// Tabular



*/