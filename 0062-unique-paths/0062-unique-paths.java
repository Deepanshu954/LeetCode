class Solution {
    public int uniquePaths(int m, int n) {
        return helper(m,n);
    }

    private int helper(int m, int n) {
        if(m == 1 || n == 1) return 1;

        int left = helper(m - 1, n);
        int right = helper(m, n - 1);

        return left + right;
    }
}