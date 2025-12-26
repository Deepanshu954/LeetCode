class Solution {
    public int maxProfit(int[] nums) {
        int prof = 0, maxProf = 0, min = nums[0];

        for(int num : nums){
            if(min > num){
                min = num;
                prof = 0;
            }
            prof = num - min;
            maxProf = Math.max(prof, maxProf);
        }
        return maxProf;
    }
}