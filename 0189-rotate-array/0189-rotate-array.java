class Solution {

    void reverseArr(int[] nums, int i, int j) {
        while(i <= j)
        {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

    public void rotate(int[] nums, int k){

        int i = 0;
        int j = nums.length - 1;

        reverseArr(nums,i, j);
        reverseArr(nums,i,k - 1);
        reverseArr(nums,k,j);
        
    }
}