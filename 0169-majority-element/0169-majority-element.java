class Solution {
    public int majorityElement(int[] nums) {
        int maj = nums[0];
        int cnt = 0;

        for(int num : nums){
            if(num == maj) cnt++;
            else if(num != maj && cnt > 0) cnt--;
            else {maj = num; cnt = 1;}
        }
        return maj;
    }
}