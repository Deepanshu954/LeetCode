class Solution {
    public int minBitFlips(int start, int goal) {
        // return Integer.bitCount((start ^ goal));

        int num = start ^ goal;

        int count = 0;

        while(num > 0) {
            // num = num & (num - 1);
            // count++;

            int bit = num & 1;
            if(bit == 1) count++;

            num >>= 1;
        }

        return count;
        
    }
}