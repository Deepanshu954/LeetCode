class Solution {
    public int minBitFlips(int start, int goal) {
        // return Integer.bitCount((start ^ goal));

        int num = start ^ goal;

        int count = 0;

        while(num > 0) {
            num = num & (num - 1);
            count++;
        }

        return count;
        
    }
}