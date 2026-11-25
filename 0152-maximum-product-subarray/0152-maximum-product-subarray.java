class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];

        int prod = 1;
        for(int i = 0; i < nums.length; i++){
            prod = 1;
            for(int j = i; j < nums.length; j++){
                prod *= nums[j];
                res = Math.max(prod, res);
            }
        }

        // int prod = 1;
        // for(int num : nums) {
        //     prod *= num;
        //     res = Math.max(res, prod);
        //     if(prod == 0) prod = 1;
        // }

        return res;
    }
}