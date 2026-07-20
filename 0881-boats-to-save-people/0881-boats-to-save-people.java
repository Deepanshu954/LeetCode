class Solution {
    public int numRescueBoats(int[] nums, int limit) {
        int cnt = 0;
        Arrays.sort(nums);
        
        int left = 0;
        int right = nums.length - 1;
        
        while(left <= right){
            int sum = nums[left] + nums[right];

            if(sum <= limit) left++;

            cnt++;
            right--;
        }
        
        return cnt;
    }
}