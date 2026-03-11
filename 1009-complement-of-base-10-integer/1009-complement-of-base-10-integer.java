class Solution {
    public int bitwiseComplement(int n) {
        if(n == 0) return 1;
        int bits = 32 - Integer.numberOfLeadingZeros(n);

        int res = (1 << bits) - n - 1;
        return res;
    }
}