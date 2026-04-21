class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];

        int[] dp = new int[n];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i = 2; i < n; i++) {
            dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);
        }

        return Math.max(dp[n-1], dp[n-2]);
    }
}

/*

class Solution {
    private int[] dp;
    
    public int rob(int[] nums) {
        int n = nums.length;

        dp = new int[n];
        Arrays.fill(dp, -1);

        return Math.max(rec(n-1, nums), rec(n-2, nums));
    }

    private int rec(int i, int[] nums) {
        if(i == 0) return nums[0];
        if(i < 0) return 0;

        if(dp[i] != -1) return dp[i];

        dp[i] = Math.max(nums[i] + rec(i-2, nums), rec(i-1, nums));

        return dp[i];
    }
}

*/