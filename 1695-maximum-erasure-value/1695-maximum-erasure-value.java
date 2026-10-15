import java.util.*;

class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> set = new HashSet<>();

        int max = 0;
        int curr = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            while (set.contains(nums[right])) {
                curr -= nums[left];
                set.remove(nums[left]);
                left++;
            }

            set.add(nums[right]);
            curr += nums[right];

            max = Math.max(max, curr);
        }

        return max;
    }
}