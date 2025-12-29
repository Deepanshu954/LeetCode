class Solution {
    public int[] searchRange(int[] nums, int target) {
        int firstIndex = startIndex(nums, target);
        if(firstIndex == -1) return new int[] {-1,-1};
        int lastIndex = endIndex(nums, target);
        return new int[] {firstIndex, lastIndex};
    }

    private int startIndex(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        int ans = -1;

        while(left <= right){
            int mid = left + (right-left)/2;

            if(nums[mid] == target){
                ans = mid;
                right = mid - 1;
            }
            else if(nums[mid] < target) left = mid+1;
            else right = mid-1;
        }

        return ans;
    }

    private int endIndex(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        int ans = -1;

        while(left <= right){
            int mid = left + (right-left)/2;

            if(nums[mid] == target){
                ans = mid;
                left = mid + 1;
            }
            else if(nums[mid] < target) left = mid+1;
            else right = mid-1;
        }

        return ans;
    }
}