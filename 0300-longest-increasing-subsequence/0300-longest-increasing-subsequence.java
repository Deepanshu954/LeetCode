class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        return rec(n-1, -1,nums);
    }

    private int rec(int i, int prev,int[] nums) {
        if(i < 0) return 0;

        // not take
        int notTake = rec(i-1, prev, nums);

        // take
        int take = 0;
        if(prev == -1 || nums[i] < nums[prev]) {
            take = 1 + rec(i-1, i, nums);
        }

        return Math.max(take, notTake);
    }
}