class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1) return nums[0];

        return Math.max(
            robLinear(nums, 0, n - 2), // exclude last
            robLinear(nums, 1, n - 1)  // exclude first
        );
    }

    private int robLinear(int[] nums, int start, int end) {
        int prev2 = 0; // dp[i-2]
        int prev1 = 0; // dp[i-1]

        for (int i = start; i <= end; i++) {
            int curr = Math.max(nums[i] + prev2, prev1);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}

// class Solution {
//     private int[] dp;
//     private int s;

//     public int rob(int[] nums) {
//         int n = nums.length;
//         if(n == 1) return nums[0];

//         dp = new int[n];

//         Arrays.fill(dp, -1);
//         s = 0;
//         int res1 = rec(n-2, nums);

//         Arrays.fill(dp, -1);
//         s = 1;
//         int res2 = rec(n-1, nums);

//         return Math.max(res1, res2);
//     }

//     private int rec(int i, int[] nums) {
//         if(i == s) return nums[s];
//         if(i < s) return 0;

//         if(dp[i] != -1) return dp[i];

//         dp[i] = Math.max(nums[i] + rec(i-2, nums), rec(i-1, nums));
//         return dp[i];
//     }
// }