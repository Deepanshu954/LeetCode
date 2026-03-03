class Solution {
    public int rob(int[] nums) {
        int res1 = 0;
        int res2 = 0;

        int t = nums.length % 2;

        for(int i = 0; i < nums.length - t; i = i + 2) {
            res1 += nums[i];
            res2 += nums[i + 1];
        }

        if(t == 1) res1 += nums[nums.length - 1];

        return res1 > res2 ? res1 : res2;
    }
}