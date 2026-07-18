class Solution {
    public long maxRunTime(int n, int[] nums) {
        long sum = 0;
        for(int num : nums) sum += num;

        long left = 0;
        long right = sum/n;

        while(left < right) {
            long mid = left + (right - left + 1)/2;

            if(isValid(nums, mid, n)) {
                left = mid;
            } else right = mid-1;
        }

        return left;
    }

    private boolean isValid(int[] batteries, long time, int n) {
    long total = 0;

    for (int battery : batteries) {
        total += Math.min((long) battery, time);
    }

    return total >= time * n;
}
}