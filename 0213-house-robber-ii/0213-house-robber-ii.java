class Solution {
    private int s;
    public int rob(int[] nums) {
        int n = nums.length;

        s = 0;
        int res1 = Math.max(rec(n-2, nums), rec(n-3, nums));
        s = 1;
        int res2 = Math.max(rec(n-1, nums), rec(n-2, nums));

        return Math.max(res1, res2);
    }

    private int rec(int i, int[] nums) {
        if(i == s) return nums[s];
        if(i == s+1) return nums[s+1];

        return  Math.max(nums[i] + rec(i-2, nums), rec(i-1, nums));
    }
}