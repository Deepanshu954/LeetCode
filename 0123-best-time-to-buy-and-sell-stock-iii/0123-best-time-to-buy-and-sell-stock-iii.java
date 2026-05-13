// Tabular

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[][][] dp = new int[n][3][2];

        // Base Case
        for (int j = 0; j < 3; j++) {
            dp[0][j][0] = 0;

            if (j > 0)
                dp[0][j][1] = -prices[0];
            else
                dp[0][j][1] = Integer.MIN_VALUE / 2; // impossible
        }

        // Rest
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < 3; j++) {

                // not holding
                dp[i][j][0] = Math.max(
                    dp[i-1][j][0],
                    dp[i-1][j][1] + prices[i]
                );

                // holding
                if(j > 0) {
                    dp[i][j][1] = Math.max(
                        dp[i-1][j][1],
                        dp[i-1][j-1][0] - prices[i]
                    );
                } else {
                    dp[i][j][1] = dp[i-1][j][1];
                }
            }
        }

        return dp[n-1][2][0];
    }
}



/*

// Recursion

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        return rec(n-1, 2, 0, prices);
    }

    private int rec(int i, int j, int k, int[] prices) {
        if(i == 0) {
            return (k == 0) ? 0 : -prices[0];
        }
        if(j == 0) {
            return 0;
        }

        if(k == 0) {
            return Math.max(
                rec(i-1, j, 0, prices),
                rec(i-1, j, 1, prices) + prices[i]
            );
        } else {
            return Math.max(
                rec(i-1, j, 1, prices),
                rec(i-1, j-1, 0, prices) - prices[i]
            );
        }
    }
}

*/

/*

// Memorization


class Solution {
    private Integer[][][] dp;
    public int maxProfit(int[] prices) {
        int n = prices.length;

        dp = new Integer[n+1][3][2];
        return rec(n-1, 2, 0, prices);
    }

    private int rec(int i, int j, int k, int[] prices) {
        if(i == 0) {
            return (k == 0) ? 0 : -prices[0];
        }
        
        if(j == 0) {
            return (k == 0) ? 0 : (int)-1e9;
        }

        if(dp[i][j][k] != null) return dp[i][j][k];

        if(k == 0) {
            dp[i][j][k] = Math.max(
                rec(i-1, j, 0, prices),
                rec(i-1, j, 1, prices) + prices[i]
            );
        } else {
            dp[i][j][k] = Math.max(
                rec(i-1, j, 1, prices),
                rec(i-1, j-1, 0, prices) - prices[i]
            );
        }

        return dp[i][j][k];
    }
}


*/