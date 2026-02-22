class Solution {
    public boolean findSubarrays(int[] nums) {
        int temp = nums[0];
        for(int i = 1; i < nums.length; i++) {
            nums[i-1] = temp + nums[i];
            temp = nums[i];
        }

        for(int i = 0; i < nums.length - 2; i++) {
            if(nums[i] == nums[i+1]) return true;
        }

        return false;
    }
}