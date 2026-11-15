class Solution {
    public int numOfSubarrays(int[] arr) {
        final int MOD = 1_000_000_007;

        long even = 1; // Empty prefix sum
        long odd = 0;

        long prefix = 0;
        long res = 0;

        for (int num : arr) {
            prefix += num;

            if (prefix % 2 == 0) {
                even++;
                res += odd;
            } else {
                odd++;
                res += even;
            }

            res %= MOD;
        }

        return (int) res;
    }
}