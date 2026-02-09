class Solution {
    
    public int[] countBits(int n) {
        // co by jmlakshmisagar
        int[] dp = new int[n + 1];
        int s = 1;
        for (int i = 1; i <= n; i++) {
            if (s * 2 == i)
                s = i;
            dp[i] = dp[i - s] + 1;
        }
        return dp;
    }
}