class Solution {

    int MOD = 1000000007;
    long[][][][] dp;

    public int numberOfStableArrays(int zero, int one, int limit) {

        dp = new long[zero + 1][one + 1][3][limit + 1];

        for(int i=0;i<=zero;i++)
            for(int j=0;j<=one;j++)
                for(int k=0;k<3;k++)
                    Arrays.fill(dp[i][j][k], -1);

        return (int) dfs(zero, one, 2, 0, limit);
    }

    long dfs(int z, int o, int last, int streak, int limit) {

        if (z == 0 && o == 0) return 1;

        if (dp[z][o][last][streak] != -1)
            return dp[z][o][last][streak];

        long res = 0;

        if (z > 0) {
            if (last != 0)
                res += dfs(z - 1, o, 0, 1, limit);
            else if (streak < limit)
                res += dfs(z - 1, o, 0, streak + 1, limit);
        }

        if (o > 0) {
            if (last != 1)
                res += dfs(z, o - 1, 1, 1, limit);
            else if (streak < limit)
                res += dfs(z, o - 1, 1, streak + 1, limit);
        }

        return dp[z][o][last][streak] = res % MOD;
    }
}