class Solution {
    public int[] productExceptSelf(int[] nums) {
        int ans = 1;
        for(int num : nums) ans *= num;

        for(int i = 0; i < nums.length; i++){
            nums[i] = ans/nums[i];
        }

        return nums;
    }
}