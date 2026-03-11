class Solution {
    public int smallestDivisor(int[] nums, int th) {
        int low = 1;
        int high = 0;

        for(int num : nums) high = Math.max(high, num);

        int ans = high;
        while(low <= high) {
            int mid = low + (high - low)/2;

            if(isValid(nums, mid, th)) {
                ans = mid;
                high = mid - 1;
            } else low = mid + 1;
        }

        return ans;
    }

    private boolean isValid(int[] nums, int a, int th) {
        int cnt = 0;

        for(int i = 0; i < nums.length; i++) {
            cnt += (nums[i] + a - 1) / a;
        }

        return cnt <= th;
    }
}