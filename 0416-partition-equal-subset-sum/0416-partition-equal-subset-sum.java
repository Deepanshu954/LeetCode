class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int num : nums) sum += num;

        if(sum % 2 == 1) return false;

        int target = sum/2;

        int[] dp = new int[target+1];

        for(int i = 0; i < n; i++) {
            for(int w = target; w >= nums[i]; w--) {
                dp[w] = Math.max(
                    dp[w],
                    nums[i] + dp[w - nums[i]]
                );
            }
        }

        return dp[target] == target;
    }
}