class Solution {
    public int maximumWealth(int[][] accounts) {
        int n = accounts.length;
        int m = accounts[0].length;
        int max = 0;

        for(int i = 0; i < n; i++) {
            int ans = 0;
            for(int j = 0; j < m; j++) {
                ans += accounts[i][j];
            }

            max = Math.max(ans, max);
        }

        return max;
    }
}