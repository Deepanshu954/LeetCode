class Solution {
    int mod = 1000000007;

    public int distinctSubseqII(String s) {
        int total = 0;
        int[] dp = new int[26];

        for(int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            int add = (total - dp[c] + mod) % mod;

            dp[c] = total + 1;
            total = (dp[c] + add) % mod;
        }
        
        return total;
    }
}