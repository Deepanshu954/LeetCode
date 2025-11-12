class Solution {
    public int maxProduct(int[] nums) {
        int ans = Integer.MIN_VALUE;
        
        for(int i = 0; i < nums.length; i++){
            int prod = 1;
            for(int j = i; j < nums.length; j++){
                prod *= nums[j];
                ans = Math.max(prod, ans);
            }
        }
        return ans;
    }
}