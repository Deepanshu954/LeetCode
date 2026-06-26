class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        if(k == 0) return;

        rev(nums, 0, n-1);
        rev(nums, 0, k-1);
        rev(nums, k, n-1);
    }

    private void rev(int[] nums, int l, int r) {
        while(l < r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;

            l++;
            r--;
        }

        return;
    }
}

// 1 2 3 4      5 6 7
// 7 6 5        4 3 2 1
// 5 6 7        1 2 3 4