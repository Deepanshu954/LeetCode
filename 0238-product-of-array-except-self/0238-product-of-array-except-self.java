class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] suffix = new int[nums.length];int prod = 1;

        for(int i = n - 1; i >= 0; i--){
            prod *= nums[i];
            suffix[i] = prod;
        }

        int[] prefix = new int[nums.length];
        prod = 1;
        for(int i = 0; i < n; i++){
            prod *= nums[i];
            prefix[i] = prod;
        }

        nums[0] = suffix[1];
        nums[n-1] = prefix[n-2];

        for(int i = 1; i < n - 1; i++){
            nums[i] = prefix[i-1] * suffix[i+1]; 
        }
        return nums;
    }
}

/*
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] suffix = new int[nums.length];int prod = 1;
        
        for(int i = n - 1; i >= 0; i--){
            prod *= nums[i];
            suffix[i] = prod;
        }

        int[] prefix = new int[nums.length];
        prod = 1;
        for(int i = 0; i < n; i++){
            prod *= nums[i];
            prefix[i] = prod;
        }

        nums[0] = suffix[1];
        nums[n-1] = prefix[n-2];

        for(int i = 1; i < n - 1; i++){
            nums[i] = prefix[i-1] * suffix[i+1]; 
        }
        return nums;
    }
}
*/