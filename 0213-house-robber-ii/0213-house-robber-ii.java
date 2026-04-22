class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0], nums[1]);
        if(n == 3) {
            return Math.max(nums[2], Math.max(nums[0], nums[1]));
        }

        int[] dp = new int[n];
        int[] res = new int[2];

        for(int i = 0; i < 2; i++) {
            int a = nums[0+i];
            int b = Math.max(nums[0+i], nums[1+i]);

            for(int j = 2+i; j < n-i; j++) {
                int c = Math.max(nums[j] + a, b);
                a = b;
                b = c;
            }

            res[i] = b;
        }




        return Math.max(res[0], res[1]);
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