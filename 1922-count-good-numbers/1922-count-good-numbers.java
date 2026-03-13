class Solution {

    static final long MOD = 1_000_000_007;

    public int countGoodNumbers(long n) {

        long ans = 1;

        if (n % 2 == 1) ans = 5;

        n = n / 2;

        ans = (ans * pow(20, n)) % MOD;

        return (int) ans;
    }

    private long pow(long val, long n) {
        if (n == 0) return 1;

        long half = pow(val, n / 2);

        long res = (half * half) % MOD;

        if (n % 2 == 1)
            res = (res * val) % MOD;

        return res;
    }
}