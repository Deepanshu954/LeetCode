class Solution {
    public double myPow(double x, int n) {
        if(n == 0) return 0;
        if(n == 1) return x;
        if(n == -1) return 1/x;

        int sign = n > 0 ? 1 : -1;

        n = Math.abs(n);

        double ans = helper(x, n);

        if(sign == -1) return 1/ ans;
        return ans;
    }

    private double helper(double num, int pow) {
        if(pow == 0) return 1;
        return num * helper(num , pow - 1);
    }
}