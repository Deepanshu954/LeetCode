/*

// Recursive
class Solution {
    int m;
    int MOD = 1000000007;

    public int zigZagArrays(int n, int l, int r) {
        m = r - l + 1;
        if (n == 1) return m;

        long totalCount = 0;
        for (int v = 0; v < m; v++) {
            totalCount = (totalCount + helper(n - 1, v, 2)) % MOD;
        }
        return (int) totalCount;
    }

    private long helper(int rem, int lastV, int reqD) {
        if (rem == 0) return 1;

        long ways = 0;
        for (int v = 0; v < m; v++) {
            if (v == lastV) continue;
            if (reqD == 0 && v <= lastV) continue;
            if (reqD == 1 && v >= lastV) continue;

            int nextD = (v > lastV) ? 1 : 0;
            ways = (ways + helper(rem - 1, v, nextD)) % MOD;
        }
        return ways;
    }
}

*/

/*
// Memorization

class Solution {
    int m;
    int MOD = 1000000007;
    Long[][][] memo;

    public int zigZagArrays(int n, int l, int r) {
        m = r - l + 1;
        if (n == 1) return m;

        memo = new Long[n][m][3];
        long totalCount = 0;
        
        for (int v = 0; v < m; v++) {
            totalCount = (totalCount + helper(n - 1, v, 2)) % MOD;
        }
        return (int) totalCount;
    }

    private long helper(int remL, int lastV, int reqD) {
        if (remL == 0) return 1;
        if (memo[remL][lastV][reqD] != null) {
            return memo[remL][lastV][reqD];
        }

        long ways = 0;
        for (int v = 0; v < m; v++) {
            if (v == lastV) continue;
            if (reqD == 0 && v <= lastV) continue;
            if (reqD == 1 && v >= lastV) continue;

            int nextD = (v > lastV) ? 1 : 0;
            ways = (ways + helper(remL - 1, v, nextD)) % MOD;
        }
        
        return memo[remL][lastV][reqD] = ways;
    }
}

*/

/*
// Tabular

class Solution {
    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;
        int MOD = 1000000007;

        if (n == 1) return m;

        long[][][] dp = new long[n + 1][m][2];

        for (int v = 0; v < m; v++) {
            dp[2][v][1] = v;
            dp[2][v][0] = m - 1 - v;
        }

        for (int i = 3; i <= n; i++) {
            for (int v = 0; v < m; v++) {
                for (int k = 0; k < v; k++) {
                    dp[i][v][1] = (dp[i][v][1] + dp[i - 1][k][0]) % MOD;
                }
                for (int k = v + 1; k < m; k++) {
                    dp[i][v][0] = (dp[i][v][0] + dp[i - 1][k][1]) % MOD;
                }
            }
        }

        long totalCount = 0;
        for (int v = 0; v < m; v++) {
            totalCount = (totalCount + dp[n][v][0] + dp[n][v][1]) % MOD;
        }

        return (int) totalCount;
    }
}

*/

// Space Optimization

class Solution {

    private static final int MOD = 1_000_000_007;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;

        // Base case
        if (n == 1) return m;

        long[] up = new long[m];     // last move was increasing
        long[] down = new long[m];   // last move was decreasing

        // Initialize for length = 2
        for (int v = 0; v < m; v++) {
            up[v] = v;               // count of smaller elements
            down[v] = m - 1 - v;     // count of larger elements
        }

        // Build for lengths 3 → n
        for (int len = 3; len <= n; len++) {

            long[] nextUp = new long[m];
            long[] nextDown = new long[m];

            // Prefix sum for "down" → builds "up"
            long prefixDown = 0;
            for (int v = 0; v < m; v++) {
                nextUp[v] = prefixDown;
                prefixDown = (prefixDown + down[v]) % MOD;
            }

            // Suffix sum for "up" → builds "down"
            long suffixUp = 0;
            for (int v = m - 1; v >= 0; v--) {
                nextDown[v] = suffixUp;
                suffixUp = (suffixUp + up[v]) % MOD;
            }

            up = nextUp;
            down = nextDown;
        }

        // Final aggregation
        long total = 0;
        for (int v = 0; v < m; v++) {
            total = (total + up[v] + down[v]) % MOD;
        }

        return (int) total;
    }
}