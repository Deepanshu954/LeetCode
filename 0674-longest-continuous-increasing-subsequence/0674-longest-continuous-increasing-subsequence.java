class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int res = 1;
        int cnt = 1;

        for(int i = 1; i < nums.length; i++) {
            if(nums[i-1] < nums[i]) cnt++;
            else cnt = 1;

            res = Math.max(res, cnt);
        }

        return res;
    }
}