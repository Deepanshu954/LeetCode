class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        return Math.max(rec(n-1, nums), rec(n-2, nums));
    }

    private int rec(int i, int[] nums) {
        if(i == 0) return nums[0];
        if(i == 1) return nums[1];

        return  Math.max(nums[i] + rec(i-2, nums), rec(i-1, nums));
    }
}