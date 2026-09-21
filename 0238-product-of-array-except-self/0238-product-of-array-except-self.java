class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int cnt = 0;
        int idx = -1;
        int prod = 1;

        // more then 1 zero
        for(int i = 0; i < n; i++) {
            if(nums[i] == 0) {
                idx = i;
                cnt++;

                if(cnt > 1) {
                    Arrays.fill(nums, 0);
                    return nums;
                }
            } else {
                prod *= nums[i];
            }
        }

        // zero cnt = 1
        if(cnt == 1) {
            Arrays.fill(nums, 0);
            nums[idx] = prod;
            return nums;
        }

        // no zeros

        for(int i = 0; i < n; i++) {
            nums[i] = prod / (nums[i]);
        }

        return nums;
    }
}