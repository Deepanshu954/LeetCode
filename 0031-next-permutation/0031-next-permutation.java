class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length - 1;

        int idx = -1;
        for(int i = n; i > 0; i--) {
            if(nums[i-1] < nums[i]) {
                idx = i-1;
                break;
            }
        }

        if(idx == -1) {
            reverse(0, n, nums);
            return;
        }

        for(int i = n; i > idx; i--) {
            if(nums[i] > nums[idx]) {

                int temp = nums[i];
                nums[i] = nums[idx];
                nums[idx] = temp;

                reverse(idx+1 , n, nums);
                break;
            }
        }
    }

    private void reverse(int idx, int n, int[] nums) {

        while(idx < n) {
            int temp = nums[idx];
            nums[idx] = nums[n];
            nums[n] = temp;

            idx++;
            n--;
        }
    }
}

/*

    1   2   3
    1   3   2


*/