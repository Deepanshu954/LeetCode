class Solution {
    public int findDuplicate(int[] nums) {

        int n = nums.length - 1;
        int ans = 0;

        // Check each bit position (0 to 31)
        for (int bit = 0; bit < 32; bit++) {

            int countNums = 0;
            int countRange = 0;

            // Count bit in nums[]
            for (int num : nums) {
                if ((num & (1 << bit)) != 0) {
                    countNums++;
                }
            }

            // Count bit in range [1..n]
            for (int i = 1; i <= n; i++) {
                if ((i & (1 << bit)) != 0) {
                    countRange++;
                }
            }

            // Extra count means duplicate has this bit
            if (countNums > countRange) {
                ans |= (1 << bit);
            }
        }

        return ans;
    }
}