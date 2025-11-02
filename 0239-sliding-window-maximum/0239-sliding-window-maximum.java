class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int size = n - k + 1;
        int[] ans = new int[size];

        int[] window = new int[k];
        for(int i = 0; i < size; i++){
            int max = -99999;
            int loop = i + k;
            for(int j = i; j < loop; j++){
                if(nums[j] > max)
                {
                    max = nums[j];
                }
            }
            ans[i] = max;
        }

        return ans;
        
    }
}