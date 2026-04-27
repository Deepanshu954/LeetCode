// Tabular

class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;

        int sum = 0;
        for(int x : nums) sum += x;
        if(sum % 2 == 1) return false;

        int k = sum/2;
        boolean[][] dp = new boolean[n][k+1];

        // Base Case
        for(int i = 0; i < n; i++) dp[i][0] = true;
        dp[0][0] = true;

        // Rest
        for(int i = 1; i < n; i++) {
            for(int j = 1; j <= k; j++) {
                boolean notTake = dp[i-1][k];

                boolean take = false;
                if(nums[i] <= j)
                    take = dp[i-1][k - nums[i]];

                dp[i][k] = notTake || take;
            }
        }


        return dp[n-1][k];
    }
}

/*

// Recursion

class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int x : nums) sum += x;

        if(sum % 2 == 1) return false;
        return rec(nums.length - 1, sum/2, nums);
    }

    private boolean rec(int i, int k, int[] nums) {
        if(k == 0) return true;
        if(i == 0) return nums[0] == k;

        // don't take
        boolean notTake = rec(i -1, k, nums);

        // take
        boolean take = false;
        if(nums[i] <= k) 
            take = rec(i-1, k - nums[i], nums);
        
        return notTake || take;
    }
}

*/

/*

// memorization

class Solution {
    private int[][] dp;
    public boolean canPartition(int[] nums) {
        int n = nums.length;

        int sum = 0;
        for(int x : nums) sum += x;
        if(sum % 2 == 1) return false;

        int k = sum/2;
        dp = new int[n][k+1];
        for(int[] d : dp) Arrays.fill(d, -1);

        return rec(n - 1, k, nums);
    }

    private boolean rec(int i, int k, int[] nums) {
        if(k == 0) return true;
        if(i == 0) return nums[0] == k;

        if(dp[i][k] != -1) return dp[i][k] == 1;

        // don't take
        boolean notTake = rec(i -1, k, nums);

        // take
        boolean take = false;
        if(nums[i] <= k) 
            take = rec(i-1, k - nums[i], nums);
        
        dp[i][k] = (notTake || take) ? 1 : 0;
        return dp[i][k] == 1;
    }
}

*/