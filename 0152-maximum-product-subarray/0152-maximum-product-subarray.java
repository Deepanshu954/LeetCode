class Solution {
    public int maxProduct(int[] nums) {
        int minProd = nums[0];
        int maxProd = nums[0];
        int res = nums[0];

        for(int i = 1; i < nums.length; i++){
            int curr = nums[i];

            if(curr < 0){
                int temp = maxProd;
                maxProd = minProd;
                minProd = temp;
            }

            int temp = curr;

            // maxProd = maxProd * curr;
            // if(maxProd < curr) maxProd = curr;

            maxProd = Math.max(maxProd * curr, curr);
            minProd = Math.min(minProd * temp, temp);

            // minProd = minProd * temp;
            // if(minProd > temp) minProd = temp;


            if(res < maxProd) res = maxProd;
        }
        
        return res;
    }
}