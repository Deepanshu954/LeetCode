class Solution {
    public void sortColors(int[] nums) {
        int cnt0 = 0, cnt1 = 0, cnt2 = 0;

        for(int num : nums) {
            if(num == 0) cnt0++;
            else if(num == 1) cnt1++;
            else cnt2++;
        }

        int idx = 0;
        while(cnt0-->0) nums[idx++] = 0;
        while(cnt1-->0) nums[idx++] = 1;
        while(cnt2-->0) nums[idx++] = 2;
    }
}