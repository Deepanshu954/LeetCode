class Solution {
    public boolean canPartition(int[] nums) {
        Arrays.sort(nums);
        
        for(int i = 1; i < nums.length; i++) {
            nums[i] += nums[i-1];
        }
        int target = nums[nums.length - 1];

        for(int num : nums) {
            if(2 * num == target) return true;
        }
        return false;
    }
}