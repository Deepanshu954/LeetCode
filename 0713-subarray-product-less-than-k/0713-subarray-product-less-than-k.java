class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        if(n == 1) {
            if(nums[0] < k) return 1;
            else return 0;
        } 

        int prod = 1;
        int cnt = 0;

        int left = 0;
        for(int right = 0; right < n; right++) {
            prod *= nums[right];

            while(prod >= k) {
                prod /= nums[left];
                left++;
            }

            cnt += (right - left + 1);
        }

        return cnt;
    }
}