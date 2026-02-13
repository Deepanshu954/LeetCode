class Solution {
    public int maxScore(int[] nums, int t) {
        int left = 0;
        int right = nums.length - 1;
        int leftSum = 0;
        int rightSum = 0;

        // while(t--> 0) {
        //     if(nums[left] >= nums[right]) sum += nums[left];
        //     else sum += nums[right];

        //     left++;
        //     right--;
        // }

        for(int i = 0; i < t; i++) leftSum += nums[i];
        while(t--> 0) rightSum += nums[right--];

        

        return Math.max(leftSum, rightSum);
    }
}