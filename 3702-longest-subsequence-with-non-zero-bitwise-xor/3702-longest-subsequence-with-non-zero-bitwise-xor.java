class Solution {
    public int longestSubsequence(int[] nums) {
        int res = 0;
        boolean zero = false;

        for(int num : nums) {
            res ^= num;
            if(num != 0) zero = true;
        }

        if(!zero) return 0;

        return (res == 0) ? nums.length - 1: nums.length;
    }
}