class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int max = piles[0];
        for(int i = 1; i < piles.length; i++) {
            max = Math.max(max, piles[i]);
        }


        int res = 0;
        int low = 1;
        int high = max;

        while(low <= high) {
            int mid = low + (high - low)/2;

            if(calc(piles, mid, h)) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return res;
    }

    private boolean calc(int[] piles, int val, int h) {
        int ans = 0;

        for(int i = 0; i < piles.length; i++) {
            int dig = piles[i] / val;
            if(piles[i] % val > 0) dig++;

            ans += dig;
        }

        return ans <= h;
    }
}