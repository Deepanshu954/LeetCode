class Solution {
    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;
        int MOD = 1000000007;

        if (n == 1) return m;

        long[] up = new long[m];
        long[] down = new long[m];
        long[] nextUp = new long[m];
        long[] nextDown = new long[m];

        for (int v = 0; v < m; v++) {
            up[v] = v;
            down[v] = m - 1 - v;
        }

        for (int i = 3; i <= n; i++) {
            long sumDown = 0;
            for (int v = 0; v < m; v++) {
                nextUp[v] = sumDown;
                sumDown = (sumDown + down[v]) % MOD;
            }

            long sumUp = 0;
            for (int v = m - 1; v >= 0; v--) {
                nextDown[v] = sumUp;
                sumUp = (sumUp + up[v]) % MOD;
            }

            long[] tempUp = up;
            up = nextUp;
            nextUp = tempUp;

            long[] tempDown = down;
            down = nextDown;
            nextDown = tempDown;
        }

        long totalCount = 0;
        for (int v = 0; v < m; v++) {
            totalCount = (totalCount + up[v] + down[v]) % MOD;
        }

        return (int) totalCount;
    }
}
