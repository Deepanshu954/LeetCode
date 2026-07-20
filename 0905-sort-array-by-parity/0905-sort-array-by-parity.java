class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        int[] arr = new int[nums.length];

        for(int num : nums) {
            if(num % 2 == 0) {
                arr[left++] = num;
            } else {
                arr[right--] = num;
            }
        }

        return arr;
    }
}