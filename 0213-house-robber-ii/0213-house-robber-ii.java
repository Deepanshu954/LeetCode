class Solution {
    private int[] dp;
    private int s;

    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];

        dp = new int[n];

        Arrays.fill(dp, -1);
        s = 0;
        int res1 = rec(n-2, nums);

        Arrays.fill(dp, -1);
        s = 1;
        int res2 = rec(n-1, nums);

        return Math.max(res1, res2);
    }

    private int rec(int i, int[] nums) {
        if(i == s) return nums[s];
        if(i < s) return 0;

        if(dp[i] != -1) return dp[i];

        dp[i] = Math.max(nums[i] + rec(i-2, nums), rec(i-1, nums));
        return dp[i];
    }
}