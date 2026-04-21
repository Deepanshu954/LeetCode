class Solution {
    private int[] dp;
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];

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