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

        int n = nums.length;
        if(n == 0) return;
        if(k == 0) return;
        int i = 0;
        int j = n - 1;

        reverseArr(nums,i, j);
        reverseArr(nums,i,k - 1);
        reverseArr(nums,k,j);
        
    }
}