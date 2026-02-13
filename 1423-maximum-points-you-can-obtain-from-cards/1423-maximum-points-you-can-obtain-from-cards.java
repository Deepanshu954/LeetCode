class Solution {
    public int maxScore(int[] nums, int t) {
        int left = 0;
        int right = nums.length - 1;
        int sum = 0;

        while(t--> 0) {
            if(nums[left] >= nums[right]) sum += nums[left];
            else sum += nums[right];

            left++;
            right--;
        }

        

        return sum;
    }
}