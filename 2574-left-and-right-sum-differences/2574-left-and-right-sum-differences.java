class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        if(n == 1) return new int[]{0};

        int[] leftSum = new int[n];
        int[] rightSum = new int[n];
        leftSum[0] = 0;
        rightSum[n-1] = 0;

        for(int i = 1; i < n; i++) {
            leftSum[i] = leftSum[i-1] + nums[i-1];
        }

        int sum = 0;
        for(int i = n-2; i >= 0; i--) {
            sum += nums[i+1];
            rightSum[i] = rightSum[i+1] + nums[i+1];
            leftSum[i] = Math.abs(leftSum[i] - sum);
        }

        // for(int i = 0; i < n; i++) {
        //     nums[i] = Math.abs(leftSum[i] - rightSum[i]);
        // }

        return leftSum;
    }
}