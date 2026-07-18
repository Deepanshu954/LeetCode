class Solution {
    public int shipWithinDays(int[] nums, int days) {
        int min = 0;
        int sum = 0;

        for(int num : nums) {
            if(num > min) min = num;
            sum += num;
        }

        int left = min;
        int right = sum;

        while(left < right) {
            int mid = left + (right - left)/2;

            if(isValid(nums, mid, days)) {
                right = mid;
            } else left = mid + 1;
        }

        return left;
    }

    private boolean isValid(int[] nums, int val, int days) {
        int sum = 0;
        int cnt = 1;

        for(int num : nums) {
            sum += num;

            if(sum > val) {
                cnt++;
                sum = num;
            }
        }

        return cnt <= days;
    }
}