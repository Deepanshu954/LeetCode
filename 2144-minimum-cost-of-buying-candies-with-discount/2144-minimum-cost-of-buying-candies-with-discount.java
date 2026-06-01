class Solution {
    public int minimumCost(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        int idx = n % 3;
        int res = 0;
        
        for(int i = 0; i < idx; i++) {
            res += nums[i];
        }

        for(int i = idx; i < n; i++) {
            if(i % 3 != 0) {
                res += nums[i];
            }
        }

        return res;
    }
}