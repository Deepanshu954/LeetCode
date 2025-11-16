class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Step 1: Ignore values <=0 or >n by turning them into n+1
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = n + 1;
            }
        }

        // Step 2: Mark presence using index
        for (int i = 0; i < n; i++) {
            int val = Math.abs(nums[i]);
            if (val >= 1 && val <= n) {
                int idx = val - 1;
                if (nums[idx] > 0) nums[idx] = -nums[idx];
            }
        }

        // Step 3: First positive index = missing number
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) return i + 1;
        }

        return n + 1;
    }
}