class Solution {
    public int[] twoSum(int[] nums, int k) {
        int l = 0;
        int r = nums.length - 1;

        while(l < r) {
            if(nums[l] + nums[r] == k) return new int[]{l+1,r+1};
            else if(nums[l] + nums[r] > k) r--;
            else l++;
        }

        return new int[]{-1, -1};
    }
}