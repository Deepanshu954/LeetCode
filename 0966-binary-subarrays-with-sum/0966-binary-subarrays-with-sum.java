class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        int count = 0;
        int ans = 0;

        // for(int i = 0; i < n; i++){
        //     int sum = 0;
        //     for(int j = i; j < n; j++){
        //         sum += nums[j];
        //         if(sum == goal) count++;
        //     }
        // }





        int left = 0, sum = 0;
        int index = 0;
        for(int right = 0; right < n; right++){
            index++;
            sum += nums[right];
            if(sum == goal){
                count++;
                break;
            }

            if(right == n - 1) return 0;
            
            // if(count > 0 && nums[right] == 0) count++;

            // while(sum > goal){
            //     sum -= nums[left];
            //     left++;
            // }

            // if(sum == goal) count++;

        }

        int ones = 0;
        int zeros = 0;
        for(int i = index; i < n; i++){
            if(nums[i] == 0) zeros++;
            else ones++;
        }

        int z = ((zeros+1)*(zeros+2))/2;
        ans = ones + z;

        return ans;
    }
}