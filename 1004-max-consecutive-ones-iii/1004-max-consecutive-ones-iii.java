class Solution {
    public int longestOnes(int[] nums, int k) {
        int max = 0;
        int cnt = 0;
        int left = 0;

        for(int right = 0; right < nums.length; right++) {
            if(nums[right] == 0) cnt++;

            while(cnt > k) {
                if(nums[left] == 0) cnt--;

                left++;
            }

            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}