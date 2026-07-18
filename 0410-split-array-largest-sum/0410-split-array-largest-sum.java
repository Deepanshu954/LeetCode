class Solution {
    public int splitArray(int[] nums, int k) {
        int left = 0;
        int right = 0;

        for(int num : nums) {
            right += num;
            left = Math.max(left, num);
        }

        while(left < right) {
            int mid = left + (right - left)/2;

            if(isValid(nums, mid, k)) {
                right = mid;
            } else left = mid + 1;
        }
        
        return left;
    }

    private boolean isValid(int[] nums, int val, int k) {
        int sum = 0;
        int cnt = 1;

        for(int num : nums) {
            sum += num;

            if(sum > val) {
                cnt++;
                sum = num;
            }
        }

        return cnt <= k;
    }
}