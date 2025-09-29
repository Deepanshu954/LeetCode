class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;

        int cnt = 0;

        for(int i = 0; i < n-1; i++){
            if(nums[i] > nums[i+1])
            {
                cnt++;
            }
        }

        if(cnt == 0) return true;

        if(nums[0] > nums[n-1] && cnt < 2)
        {
            return true;
        }

        return false;
    }
}