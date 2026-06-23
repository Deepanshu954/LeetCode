// // Recursive
// class Solution {
//     int m;
//     int MOD = 1000000007;

//     public int zigZagArrays(int n, int l, int r) {
//         m = r - l + 1;
//         if (n == 1) return m;

//         long totalCount = 0;
//         for (int v = 0; v < m; v++) {
//             totalCount = (totalCount + calculateWays(n - 1, v, 2)) % MOD;
//         }
//         return (int) totalCount;
//     }

//     private long calculateWays(int remainingLength, int lastValue, int requiredDirection) {
//         if (remainingLength == 0) return 1;

//         long ways = 0;
//         for (int v = 0; v < m; v++) {
//             if (v == lastValue) continue;
//             if (requiredDirection == 0 && v <= lastValue) continue;
//             if (requiredDirection == 1 && v >= lastValue) continue;

//             int nextDirection = (v > lastValue) ? 1 : 0;
//             ways = (ways + calculateWays(remainingLength - 1, v, nextDirection)) % MOD;
//         }
//         return ways;
//     }
// }

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
            totalCount = (totalCount + calculateWays(n - 1, v, 2)) % MOD;
        }
        return (int) totalCount;
    }

    private long calculateWays(int remainingLength, int lastValue, int requiredDirection) {
        if (remainingLength == 0) return 1;
        if (memo[remainingLength][lastValue][requiredDirection] != null) {
            return memo[remainingLength][lastValue][requiredDirection];
        }

        long ways = 0;
        for (int v = 0; v < m; v++) {
            if (v == lastValue) continue;
            if (requiredDirection == 0 && v <= lastValue) continue;
            if (requiredDirection == 1 && v >= lastValue) continue;

            int nextDirection = (v > lastValue) ? 1 : 0;
            ways = (ways + calculateWays(remainingLength - 1, v, nextDirection)) % MOD;
        }
        
        return memo[remainingLength][lastValue][requiredDirection] = ways;
    }
}