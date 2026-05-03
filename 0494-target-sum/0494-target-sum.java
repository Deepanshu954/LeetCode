class Solution {
    private int mod = (int)1e9;
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;

        int total = 0;
        for(int x : nums) total += x;
        int k = total - target;

        if(k < 0 || k % 2 == 1) return 0;
        k = k/2;

        int[] dp = new int[k+1];

        // Base Case
        dp[0] = (nums[0] == 0) ? 2 : 1;

        if(nums[0] != 0 && nums[0] <= k) dp[nums[0]] = 1;

        // rest
        for(int i = 1; i < n; i++) {
            for(int j = k; j >= nums[i]; j--) {
                int notTake = dp[j];

                int take = 0;
                if(nums[i] <= j) {
                    take = dp[j - nums[i]];
                }

                dp[j] = (take + notTake) % mod;
            }
        }
        
        return dp[k];
    }
}
