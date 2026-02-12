//o(n), o(n)

class Solution {

    public int subarraysWithKDistinct(int[] nums, int k) {
        return countAtMost(nums, k) - countAtMost(nums, k - 1);
    }

    private int countAtMost(int[] nums, int k) {
        int left = 0;
        int result = 0;
        int unique = 0;

        int[] freq = new int[nums.length+1];

        for (int right = 0; right < nums.length; right++) {

            // Add nums[right] into window
            if (freq[nums[right]] == 0) {
                unique++;
            }
            freq[nums[right]]++;

            // Shrink window if distinct > k
            while (unique > k) {
                freq[nums[left]]--;
                if (freq[nums[left]] == 0) {
                    unique--;
                }
                left++;
            }

            // Count valid subarrays
            result += right - left + 1;
        }

        return result;
    }
}