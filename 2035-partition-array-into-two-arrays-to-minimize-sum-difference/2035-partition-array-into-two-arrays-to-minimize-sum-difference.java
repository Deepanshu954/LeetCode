class Solution {
    private int res = (int)1e8;
    private int sum = 0;
    public int minimumDifference(int[] nums) {
        int n = nums.length;
        
        if(n == 2) return Math.abs(nums[0] - nums[1]);

        for(int x : nums) sum += x;
        int k = sum;

        rec(n-1, k, nums);
        return res;
    }

    private void rec(int i, int k, int[] nums) {
        if(i < 0) return;

        int abs = Math.abs(k - (sum - k));
        res = Math.min(res, abs);

        rec(i-1, k-nums[i], nums);
        rec(i-1, k, nums);
        return;
    }
}