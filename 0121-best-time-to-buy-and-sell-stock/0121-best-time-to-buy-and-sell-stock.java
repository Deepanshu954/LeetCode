class Solution {
    public int maxProfit(int[] nums) {

        int prof = 0;
        int maxProf = 0;
        int min = nums[0];

        for(int num : nums) {
            if(num < min) {prof = 0; min = num;};
            prof = num - min;
            maxProf = Math.max(prof, maxProf);
        }

        return maxProf;
        
    }
}