class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;

        int sum = 0;
        int maxSum = 0;

        for(int i = 0; i < n; i++) {
            sum = 0;
            for(int j = i; j < n; j++) {
                sum += nums[j];
                maxSum = Math.max(sum, maxSum);
            }
        }

        return maxSum;
    }
}