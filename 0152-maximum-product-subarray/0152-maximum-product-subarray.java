class Solution {
    public int maxProduct(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int prod = 1;
        
        // for(int i = 0; i < nums.length; i++){
        //     prod = 1;
        //     for(int j = i; j < nums.length; j++){
        //         prod *= nums[j];
        //         ans = Math.max(prod, ans);
        //     }
        // }

        for(int i = 0; i < nums.length; i++){
            prod *= nums[i];

            ans = Math.max(prod, ans);
            if(prod <= 0) prod = 1;
        }
        
        return ans;
    }
}