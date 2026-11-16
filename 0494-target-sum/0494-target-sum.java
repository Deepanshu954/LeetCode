class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int total = 0;
        for(int num : nums) total += num;
        if(total < Math.abs(target)) return 0;

        int[][] dp = new int[nums.length][2 * total + 1];
        for(int[] d : dp) Arrays.fill(d, -1);

        return helper(nums, target, total, nums.length, 0, dp);
    }

    private int helper(int[] nums, int target, int total, int n, int sum, int[][] dp) {
        if(n == 0) {
            return ( sum == target ) ? 1 : 0;
        }

        if( dp[n-1][sum + total] != -1 ) return dp[n-1][sum + total];

        dp[n-1][sum + total] = 
            helper(nums, target, total, n-1, sum - nums[n-1], dp) +
            helper(nums, target, total, n-1, sum + nums[n-1], dp);

        return dp[n-1][sum + total];
    }
}


// class Solution {
//     private int cnt;

//     public int findTargetSumWays(int[] nums, int target) {
//         cnt = 0;

//         helper(nums, nums.length, target);
//         return cnt;
//     }

//     private void helper(int[] nums, int n, int target) {
//         if(n == 0 && target == 0) cnt++;
//         if(n == 0) return;

//         // take it
//         helper(nums, n-1, target - nums[n-1]);

//         // skip it
//         helper(nums, n-1, target + nums[n-1]);
//     }
// }