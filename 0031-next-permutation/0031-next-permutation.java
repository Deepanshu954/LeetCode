class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length - 1;

        int index1 = -1;
        int index2 = -1;

        for(int i = n; i > 0; i--) {
            if(nums[i] > nums[i-1]) {
                index1 = i - 1;
                break;
            }
        }

        if(index1 != -1) {

            for(int i = n; i > index1; i--) {
                if(nums[i] > nums[index1]) {
                    index2 = i;
                    break;
                }
            }


            int temp = nums[index1];
            nums[index1] = nums[index2];
            nums[index2] = temp;

        }

        int left = index1 + 1;
        int right = n;

        while(left < right) {
            int t = nums[left];
            nums[left] = nums[right];
            nums[right] = t;

            left++;
            right--;
        }
        
        return;
    }
}