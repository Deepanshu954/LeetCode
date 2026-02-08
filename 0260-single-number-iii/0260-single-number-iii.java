class Solution {
    public int[] singleNumber(int[] nums) {
        if(nums.length == 2) return nums;
        Arrays.sort(nums);

        int[] arr = new int[2];
        int index = 0;

        for(int i = 1; i < nums.length - 1; i++){
            if( (nums[i - 1] == nums[i]) || (nums[i] == nums[i+1] ) ) continue;

            arr[index++] = nums[i];
        }

        if(nums[nums.length - 1] != nums[nums.length - 2]) arr[1] = nums.length - 1;
        return arr;
    }
}