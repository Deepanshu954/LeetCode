class Solution {
    public boolean stoneGameIX(int[] stones) {
        int[] cnt = new int[]{0,0,0};

        for(int i = 0; i < stones.length; i++) {
            stones[i] %= 3;
            cnt[stones[i]]++;
        }

        if(cnt[0] % 2 == 0) {
            return cnt[1] != 0 && cnt[2] != 0;
        } 

        return Math.abs(cnt[2] - cnt[1]) >= 3;
    }
}