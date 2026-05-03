class Solution {
    private int[][] dp;
    public int change(int k, int[] nums) {
        int n = nums.length;

        dp = new int[n][k+1];
        for(int[] d : dp) Arrays.fill(d, -1);

        return rec(n-1, k, nums);
    }

    private int rec(int i, int k, int[] nums) {
        if (i == 0) {
            return (k % nums[0] == 0) ? 1 : 0;
        }


        if(dp[i][k] != -1) return dp[i][k];

        int notTake = rec(i - 1, k, nums);

        int take = 0;
        if (nums[i] <= k) {
            take = rec(i , k - nums[i], nums);
        }

        return dp[i][k] = take + notTake;
    }
}

/* 

// Recursion

class Solution {
    public int change(int k, int[] nums) {
        int n = nums.length;

        return rec(n-1, k, nums);
    }

    private static int rec(int i, int k, int[] nums) {
        if (i == 0) {
            return (k % nums[0] == 0) ? 1 : 0;
        }

        int notTake = rec(i - 1, k, nums);

        int take = 0;
        if (nums[i] <= k) {
            take = rec(i , k - nums[i], nums);
        }

        return take + notTake;
    }
}

*/

