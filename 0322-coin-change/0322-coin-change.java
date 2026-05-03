class Solution {
    private int res;
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        Arrays.sort(coins);
        res = (int)1e9;

        rec(n-1,  amount, 0 ,coins);
        return (res == (int)1e9) ? -1 : res;
    }

    private void rec(int i, int k, int s,int[] nums) {
        if(i < 0 || k < 0) return;
        if(k == 0) {
            res = Math.min(res, s);
            return;
        }

        if(nums[i] <= k) {
            rec(i, k-nums[i], s+1,nums);
        }

        rec(i-1, k, s, nums);
    }
}