class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while(left < right){
            int mid = left + (right - left)/2;
            // if(nums[left] < nums[mid] && nums[mid] > nums[right])
            // {
            //     if(nums[mid] < minVal) minVal = nums[mid];
            //     left = mid + 1;
            // }
            // else
            // {
            //     if(nums[left] < nums[mid]){
            //         if(nums[mid] < minVal) minVal = nums[mid];
            //         left = mid + 1;
            //     }
            //     right = mid - 1;
            // }

            if(nums[right] < nums[mid]) left = mid + 1;
            else right = mid;


        }

        return nums[left];
    }
}