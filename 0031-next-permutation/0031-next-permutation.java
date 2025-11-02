class Solution {

    void reverse(int[] nums) {
        int i = 0; 
        int j = nums.length - 1;
        while(i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

    public void nextPermutation(int[] nums) {
        int n = nums.length;

        for(int i = n - 1; i >= 0; i--) {
            if(nums[i] > nums[i+1]) {
                continue;
            }
        }

        while(i != 0 || )
        
    }
}