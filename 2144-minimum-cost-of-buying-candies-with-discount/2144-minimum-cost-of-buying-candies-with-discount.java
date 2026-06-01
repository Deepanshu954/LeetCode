import java.util.Arrays;

class Solution {
    public int minimumCost(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int res = 0;
        
        // Count from right to left, skipping every 3rd candy
        for (int i = n - 1; i >= 0; i -= 3) {
            res += nums[i];          // Buy the most expensive remaining candy
            if (i - 1 >= 0) {
                res += nums[i - 1];  // Buy the 2nd most expensive remaining candy
            }
            // The 3rd one at (i - 2) is free, so we automatically skip it by doing i -= 3
        }
        return res;
    }
}
