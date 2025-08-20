class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length, maxCount = 0,count = 0;

        for(int num : nums) {
            if(num == 1) count++;
            if(count > maxCount) maxCount = count;
            else if(num == 0) count = 0;
        }
        return maxCount;
    }
}