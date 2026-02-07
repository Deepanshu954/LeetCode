class Solution {
    public int reversePairs(int[] nums) {
        int n = nums.length;
        int count = 0;

        for(int i = 0; i < n - 1; i++) {
            for(int j = i + 1; j < n; j++) {
                long val = 2 * nums[j];
                if(nums[i] > val) count++;
            }
        }
        
        return count;
    }
}