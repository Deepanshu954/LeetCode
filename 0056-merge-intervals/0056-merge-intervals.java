class Solution {
    public int[][] merge(int[][] nums) {
        if (nums.length == 0) return new int[0][];

        // Sort by start time
        Arrays.sort(nums, (a, b) -> a[0] - b[0]);

        int idx = 0;
        for (int[] curr : nums) {

            // Overlap check: last end >= current start
            if (nums[idx][1] >= curr[0]) {
                nums[idx][1] =
                        Math.max(nums[idx][1], curr[1]);
            } else {
                idx++;
                nums[idx] = curr;
            }
        }

        return Arrays.copyOfRange(nums, 0, idx + 1);
    }
}