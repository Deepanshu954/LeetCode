class Solution {
    public int shipWithinDays(int[] nums, int days) {

        int low = 0;
        int high = 0;

        for(int num : nums) {
            low = Math.max(low, num); // max weight
            high += num;              // total sum
        }

        int ans = high;

        while(low <= high) {
            int mid = low + (high - low)/2;

            if(isValid(nums, mid, days)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private boolean isValid(int[] weights, int capacity, int days) {
        int usedDays = 1;
        int load = 0;

        for(int w : weights) {
            if(load + w > capacity) {
                usedDays++;
                load = 0;
            }
            load += w;
        }

        return usedDays <= days;
    }
}