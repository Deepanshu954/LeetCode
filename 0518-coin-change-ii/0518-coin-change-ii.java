// space optimization

class Solution {
    public int change(int k, int[] nums) {
        int n = nums.length;
        int[] dp = new int[k+1];

        // Base Case
        for(int j = 0; j <= k; j++) {
            if(j % nums[0] == 0) {
                dp[j] = 1;
            } 
        }

        // Rest
        for(int i = 1; i < n; i++) {
            for(int j = 0; j <= k; j++) {
                int notTake = dp[j];

                int take = 0;
                if(nums[i] <= j) {
                    take = dp[j - nums[i]];
                }

                dp[j] = take + notTake;
            }
        }

        return dp[k];
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

/*

// Memorization

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

*/

/*

// Tabular

class Solution {
    private int[][] dp;
    public int change(int k, int[] nums) {
        int n = nums.length;
        dp = new int[n][k+1];

        // Base Case
        for(int j = 0; j <= k; j++) {
            if(j % nums[0] == 0) {
                dp[0][j] = 1;
            } 
        }

        // Rest
        for(int i = 1; i < n; i++) {
            for(int j = 0; j <= k; j++) {
                int notTake = dp[i-1][j];

                int take = 0;
                if(nums[i] <= j) {
                    take = dp[i][j - nums[i]];
                }

                dp[i][j] = take + notTake;
            }
        }

        return dp[n-1][k];
    }
}


*/