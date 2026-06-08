class Solution {
    public int[] pivotArray(int[] nums, int p) {
        int n = nums.length;

        int[] arr = new int[n];

        int idx = 0;
        for(int i = 0; i < n; i++) {
            if(nums[i] < p) {
                arr[idx++] = nums[i];
            }
        }

        for(int i = 0; i < n; i++) {
            if(nums[i] == p) {
                arr[idx++] = nums[i];
            }
        }

        for(int i = 0; i < n; i++) {
            if(nums[i] > p) {
                arr[idx++] = nums[i];
            }
        }

        return arr;
    }
}