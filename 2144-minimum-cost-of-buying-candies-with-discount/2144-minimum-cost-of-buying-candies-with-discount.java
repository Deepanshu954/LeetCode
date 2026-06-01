import java.util.Arrays;

class Solution {
    public int minimumCost(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int res = 0;
        
        for (int i = n - 1; i >= 0; i -= 3) {
            res += nums[i]; 
            if (i - 1 >= 0) {
                res += nums[i - 1];
            }
        }
        return res;
    }
}
