class Solution {
    public int maxProduct(int[] nums) {
        int minProd = nums[0];
        int maxProd = nums[0];
        int res = nums[0];

        for(int i = 1; i < nums.length; i++){
            int num = nums[i];

            if(num < 0){
                int temp = maxProd;
                maxProd = minProd;
                minProd = temp;
            }

            maxProd = Math.max(maxProd * num, num);
            minProd = Math.min(minProd * num, num);
            res = Math.max(res, maxProd);
        }
        
        return res;
    }
}