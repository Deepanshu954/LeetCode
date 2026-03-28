class Solution {
    public int majorityElement(int[] nums) {
        if(nums.length == 0) return - 1;
        if(nums.length == 1) return nums[0];

        int cnt = 1;
        int ans = nums[0];

        for(int i = 1; i < nums.length; i++) {
            if(ans == nums[i]) cnt++;
            else if(ans != nums[i] && cnt > 0) cnt--;
            else {
                ans = nums[i];
                cnt = 1;
            }
        }

        return ans;
    }
}