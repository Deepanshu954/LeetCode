// // // Recursive
// // class Solution {
// //     int m;
// //     int MOD = 1000000007;

// //     public int zigZagArrays(int n, int l, int r) {
// //         m = r - l + 1;
// //         if (n == 1) return m;

// //         long totalCount = 0;
// //         for (int v = 0; v < m; v++) {
// //             totalCount = (totalCount + calculateWays(n - 1, v, 2)) % MOD;
// //         }
// //         return (int) totalCount;
// //     }

// //     private long calculateWays(int remainingLength, int lastValue, int requiredDirection) {
// //         if (remainingLength == 0) return 1;

// //         long ways = 0;
// //         for (int v = 0; v < m; v++) {
// //             if (v == lastValue) continue;
// //             if (requiredDirection == 0 && v <= lastValue) continue;
// //             if (requiredDirection == 1 && v >= lastValue) continue;

// //             int nextDirection = (v > lastValue) ? 1 : 0;
// //             ways = (ways + calculateWays(remainingLength - 1, v, nextDirection)) % MOD;
// //         }
// //         return ways;
// //     }
// // }

// // Memorization

// class Solution {
//     int m;
//     int MOD = 1000000007;
//     Long[][][] memo;

//     public int zigZagArrays(int n, int l, int r) {
//         m = r - l + 1;
//         if (n == 1) return m;

//         memo = new Long[n][m][3];
//         long totalCount = 0;
        
//         for (int v = 0; v < m; v++) {
//             totalCount = (totalCount + calculateWays(n - 1, v, 2)) % MOD;
//         }
//         return (int) totalCount;
//     }

//     private long calculateWays(int remainingLength, int lastValue, int requiredDirection) {
//         if (remainingLength == 0) return 1;
//         if (memo[remainingLength][lastValue][requiredDirection] != null) {
//             return memo[remainingLength][lastValue][requiredDirection];
//         }

//         long ways = 0;
//         for (int v = 0; v < m; v++) {
//             if (v == lastValue) continue;
//             if (requiredDirection == 0 && v <= lastValue) continue;
//             if (requiredDirection == 1 && v >= lastValue) continue;

//             int nextDirection = (v > lastValue) ? 1 : 0;
//             ways = (ways + calculateWays(remainingLength - 1, v, nextDirection)) % MOD;
//         }
        
//         return memo[remainingLength][lastValue][requiredDirection] = ways;
//     }
// }


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
