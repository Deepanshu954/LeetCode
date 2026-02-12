class Solution {
    public int totalFruit(int[] nums) {
        int n = nums.length;

        int basket1 = nums[0];
        int cnt1 = 1;

        int basket2 = -1;
        int cnt2 = 0;

        int max = 0;

        int left = 0;
        for(int right = 1; right < n; right++) {
            if(nums[right] == basket1) cnt1++;
            else if(nums[right] == basket2) cnt2++;
            else {
                while( (cnt1 > 0) && (cnt2 > 0) ) {
                    if(nums[left] == basket1) cnt1--;
                    else cnt2--;

                    left++;
                }

                if(cnt1 == 0) {
                    basket1 = nums[right];
                    cnt1 = 1;
                } else {
                    basket2 = nums[right];
                    cnt2 = 1;
                }
            }

            max = Math.max(max, right - left + 1);
        }
        
        return max;
    }
}