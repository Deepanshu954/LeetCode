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

            int temp = curr;

            maxProd = maxProd * curr;
            if(maxProd < curr) maxProd = curr;

            minProd = minProd * temp;
            if(minProd > temp) minProd = temp;


            if(ans < maxProd) ans = maxProd;
        }
        
        return ans;
    }
}