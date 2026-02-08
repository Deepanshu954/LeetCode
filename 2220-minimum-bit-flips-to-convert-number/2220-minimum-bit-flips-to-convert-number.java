class Solution {
    public int minBitFlips(int start, int goal) {

        int ans = start ^ goal;

        ans = Integer.bitCount(ans);
        return ans;
        
    }
}