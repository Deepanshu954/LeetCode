class Solution {
    public int shipWithinDays(int[] nums, int days) {
        int left = 0;
        int right = 0;

        for (int num : nums) {
            left = Math.max(left, num);
            right += num;
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (isValid(nums, mid, days)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean isValid(int[] nums, int capacity, int days) {
        int usedDays = 1;
        int sum = 0;

        for (int num : nums) {
            if (sum + num > capacity) {
                usedDays++;
                sum = num;
            } else {
                sum += num;
            }
        }

        return usedDays <= days;
    }
}