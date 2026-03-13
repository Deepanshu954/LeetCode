class Solution {
    public int missingNumber(int[] nums) {
        int index = 0;

        while(index < nums.length) {
            if(nums[index] < nums.length && nums[index] != nums[nums[index]]) {
                int temp = nums[index];
                nums[index] = nums[temp];
                nums[temp] = temp;
            } else index++;
        }

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != i) return i;
        }

        return nums.length;
    }
}