class Solution {
    public int countPrimeSetBits(int left, int right) {
        boolean[] prime = new boolean[33];
        prime[2] = prime[3] = prime[5] = prime[7] =
        prime[11] = prime[13] = prime[17] = prime[19] = true;

        int count = 0;

        for(int i = left; i <= right; i++) {
            if(prime[Integer.bitCount(i)]) count++;
        }

        return count;
    }
}