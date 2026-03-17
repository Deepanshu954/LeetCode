class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if(bloomDay.length < (long)m * k) return -1;

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for(int num : bloomDay) {
            low = Math.min(low, num);
            high = Math.max(high, num);
        }

        while(low < high) {
            int mid = low + (high - low)/2;
            if(canMake(bloomDay, m, k, mid)) {
                high = mid;
            } else low = mid + 1;
        }

        return low;
    }

    private boolean canMake(int[] nums, int m, int k, int days) {
        int cnt = 0;
        int con = 0;

        for(int num : nums) {
            if(num <= days) { 
                con++;
                if(con == k) {
                    cnt++;
                    con = 0;
                    
                    if(cnt >= m) return true; // 🔥 CRITICAL FIX
                }
            } else {
                con = 0;
            }
        }

        return false;
    }

}