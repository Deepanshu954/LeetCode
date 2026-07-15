class Solution {
    public int gcdOfOddEvenSums(int n) {
        int odd = n*n;
        int even = odd + n;

        while(odd != 0) {
            int temp = odd;
            odd = even % odd;
            even = temp;
        }

        return Math.abs(even);
    }
}