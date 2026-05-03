class Solution {
    public int change(int k, int[] nums) {
        int n = nums.length;
        if(nums[0] == k && n == 1) return 1;

        return rec(n-1, k, nums);
    }

    private int rec(int i, int k, int[] nums) {
        if(i == 0) {
            return (k == 0) ? 1 : 0;
        }

        int notTake = rec(i-1, k, nums);

        int take = 0;
        if(nums[i] <= k) {
            take = 1 + rec(i, k - nums[i], nums);
        }

        return notTake + take;
    }
}