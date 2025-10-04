class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int cnt = 0, maxLen = 0, left = 0;

        for(int right = 0; right < n; right++){

            if(nums[right] == 0) cnt++;

            while(cnt > k){
                if(nums[left] == 0) cnt--;
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
        
    }
}