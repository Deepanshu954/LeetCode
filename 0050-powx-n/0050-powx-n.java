class Solution {
    public double myPow(double x, int n) {
        if(n == 0) return 1;

        if(n > 0) return helper(x, n);
        else return 1 / helper(x, -n);
    }

    private double helper(double x, int n) {
        if(n == 0) return 1;

        return x * helper(x, n-1);
    }
}