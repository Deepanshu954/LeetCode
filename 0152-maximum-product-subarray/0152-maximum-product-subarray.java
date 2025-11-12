class Solution {
    public int maxProduct(int[] nums) {
        int minProd = nums[0];
        int maxProd = nums[0];
        int ans = nums[0];


        // int prod = 1;
        // for(int i = 0; i < nums.length; i++){
        //     prod = 1;
        //     for(int j = i; j < nums.length; j++){
        //         prod *= nums[j];
        //         ans = Math.max(prod, ans);
        //     }
        // }

        for(int i = 1; i < nums.length; i++){
            int curr = nums[i];

            if(curr < 0){
                int temp = maxProd;
                maxProd = minProd;
                minProd = temp;
            }

            maxProd = Math.max(curr, maxProd * curr);
            minProd = Math.min(curr, minProd * curr);

            ans = Math.max(ans, maxProd);
        }
        
        return ans;
    }
}