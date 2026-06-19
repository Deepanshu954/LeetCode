class Solution {
    public int largestAltitude(int[] nums) {
        int res = 0;
        int sum = 0;

        for(int num : nums) {
            sum += num;
            res = Math.max(res, sum);
        }

        return res;
    }
}