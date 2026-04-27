class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int x : nums) sum += x;
        if(sum % 2 == 1) return false;

        int t = sum / 2;

        return rec(nums.length - 1, t, nums);
    }

    private boolean rec(int i, int target, int[] nums) {
        if(target == 0) return true;
        if(target < 0 || i == 0) return false;

        boolean take = rec(i-1, target - nums[i], nums);
        boolean nottake = rec(i-1, target, nums);

        return take || nottake;
    }
}