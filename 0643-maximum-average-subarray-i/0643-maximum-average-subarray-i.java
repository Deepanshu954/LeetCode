class Solution {
    public double findMaxAverage(int[] nums, int k) {
        if(nums.length == 1 && k == 1) return nums[0];
        
        int sum = 0;
        double maxSum = 0;
        int left = 0;

        for(int right = 0; right < nums.length; right++) {
            if(right < k - 1) {
                sum += nums[right];
                continue;
            }

            sum += nums[right];

            if(sum > maxSum) maxSum = sum;

            sum -= nums[left++];
        }

        return maxSum/k;
        
    }
}