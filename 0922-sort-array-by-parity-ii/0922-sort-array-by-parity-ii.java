class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int n = nums.length;

        int[] res = new int[n];

        int odd = 0;
        int even = 1;
        for(int i = 0; i < n; i++) {
            if(nums[i] % 2 == 0) {
                res[odd] = nums[i];
                odd += 2;
            } else {
                res[even] = nums[i];
                even += 2;
            }
        }

        return res;
    }
}