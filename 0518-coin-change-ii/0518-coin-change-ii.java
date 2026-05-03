class Solution {
    public int change(int k, int[] nums) {
        int n = nums.length;

        return rec(n-1, k, nums);
    }

    private static int rec(int i, int k, int[] nums) {
        if (i == 0) {
            return (k % nums[0] == 0) ? 1 : 0;
        }

        int notTake = rec(i - 1, k, nums);

        int take = 0;
        if (nums[i] <= k) {
            take = rec(i , k - nums[i], nums);
        }

        return take + notTake;
    }
}