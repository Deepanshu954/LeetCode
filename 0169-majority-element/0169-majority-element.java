class Solution {
    public int majorityElement(int[] nums) {
        int cnt = 0;
        int res = 0;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == res) cnt++;
            else if(nums[i] != res && cnt > 0) cnt--;
            else {
                cnt = 0;
                res = nums[i];
            }
        }

        return res;
    }
}