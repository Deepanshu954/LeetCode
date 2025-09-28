class Solution {
    public int findLHS(int[] nums) {
        int n = nums.length;

        Arrays.sort(nums);

        int ans = 0;
        int left = 0;

        for(int right = 0; right < n; right++){
            if(nums[right] - nums[left] == 1){
                ans = Math.max(ans, right - left + 1);
            }

            while(nums[right] - nums[left] > 1){
                left++;
            }
        }

        return ans;
        
    }
}