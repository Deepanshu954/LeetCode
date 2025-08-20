class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int maj = 0;
        int max = 0;

        for(int num : nums) {
            if(maj == num) max++;
            else if(maj != num && max > 0) max--;
            else if(maj != num && max == 0) {maj = num; max++;};
        }

        return maj;
    }
}