class Solution {
    public int findMaxLength(int[] nums) {
        int max = 0;

        for(int i = 0; i < nums.length; i++) {
            int cnt0 = 0;
            int cnt1 = 0;
            for(int j = i; j < nums.length; j++) {
                if(nums[j] == 0) cnt0++;
                else cnt1++;

                if(cnt0 == cnt1) {
                    max = Math.max(cnt0 * 2, max);
                }
            }
        }

        return max;
    }
}