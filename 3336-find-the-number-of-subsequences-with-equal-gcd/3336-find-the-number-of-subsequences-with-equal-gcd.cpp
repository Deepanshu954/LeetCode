class Solution {
public:
    static constexpr int MAX = 200;
    static constexpr int MOD = 1000000007;

    int subsequencePairCount(vector<int>& nums) {

        static int dp[MAX + 1][MAX + 1];
        static int ndp[MAX + 1][MAX + 1];

        memset(dp, 0, sizeof(dp));
        dp[0][0] = 1;

        for (int x : nums) {

            memset(ndp, 0, sizeof(ndp));

            for (int g1 = 0; g1 <= MAX; g1++) {
                for (int g2 = 0; g2 <= MAX; g2++) {

                    int cur = dp[g1][g2];
                    if (!cur) continue;

                    // Option 1: Ignore current number.
                    ndp[g1][g2] = (ndp[g1][g2] + cur) % MOD;

                    // Option 2: Add it to seq1.
                    int ng1 = (g1 == 0) ? x : gcd(g1, x);
                    ndp[ng1][g2] = (ndp[ng1][g2] + cur) % MOD;

                    // Option 3: Add it to seq2.
                    int ng2 = (g2 == 0) ? x : gcd(g2, x);
                    ndp[g1][ng2] = (ndp[g1][ng2] + cur) % MOD;
                }
            }

            memcpy(dp, ndp, sizeof(dp));
        }

        long long ans = 0;

        // Both subsequences must be non-empty
        // and have the same GCD.
        for (int g = 1; g <= MAX; g++)
            ans = (ans + dp[g][g]) % MOD;

        return ans;
    }
};