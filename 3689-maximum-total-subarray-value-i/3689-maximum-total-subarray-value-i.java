class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;
        int min = (int)1e9;
        int max = -1;
        for(int j = 0; j < n; j++) {
            min = Math.min(min, nums[j]);
            max = Math.max(max, nums[j]);
        }

        long diff = max - min;

        return k * diff; 
    }
}