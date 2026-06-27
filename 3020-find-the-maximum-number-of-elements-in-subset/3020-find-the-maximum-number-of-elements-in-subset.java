class Solution {
    public int maximumLength(int[] nums) {
        // dp[last_parity][next_expected_parity]
        int[][] dp = new int[2][2];
        int maxLength = 0;
        
        for (int num : nums) {
            int currentParity = (num % 2 + 2) % 2; // Safe modulo
            
            for (int prevParity = 0; prevParity < 2; prevParity++) {
                // Extend the sequence ending at prevParity with currentParity
                dp[currentParity][prevParity] = dp[prevParity][currentParity] + 1;
                maxLength = Math.max(maxLength, dp[currentParity][prevParity]);
            }
        }
        
        return maxLength-1;
    }
}
