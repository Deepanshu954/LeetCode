class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);

        long sum = 0;
        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            // shrink window if cost > k
            while ((long) nums[right] * (right - left + 1) - sum > k) {
                sum -= nums[left];
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}