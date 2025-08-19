class Solution {

    void reverseArr(int[] nums, int i, int j) {
        while(i < j)
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
        k = k % n;
        if(k == 0) return;

        reverseArr(nums , 0 , n-1);
        reverseArr(nums , 0 , k-1);
        reverseArr(nums , k , n-1);
        
    }
}