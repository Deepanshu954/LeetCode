class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = (int)1e5 + 1;

        int[] diff = new int[n];
        long k = (long)k1 + (long)k2;
        long sum = 0;
        int max = 0;

        // cnt the diff
        for(int i = 0; i < nums1.length; i++) {
            int x = Math.abs(nums1[i] - nums2[i]);

            diff[x]++;
            sum += x;
            max = Math.max(max, x);
        }

        // k >= total sum -> return 0
        if(k >= sum ) return 0;

        // work on the biggest diff level by level
        for(int i = max; i > 0 && k > 0; i--) {
            long move = Math.min(k, diff[i]);

            diff[i] -= move;
            diff[i-1] += move;
            k -= move;
        }

        // add up all the sq

        long res = 0;

        for(int i = 0; i <= max; i++) {
            res += (long) i * i * diff[i];
        }

        return res;
    }
}