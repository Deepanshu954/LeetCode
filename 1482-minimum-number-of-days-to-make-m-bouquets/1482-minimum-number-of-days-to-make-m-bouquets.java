class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if(bloomDay.length < m * k) return -1;

        int low = 1;
        int high = 1;

        for(int num : bloomDay) high = Math.max(num, high);

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
                }
            }
            else {
                con = 0;
            }
        }

        return cnt >= m;
    }

}