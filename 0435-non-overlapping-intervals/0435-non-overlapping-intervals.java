class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length == 0) return 0;

        Arrays.sort(intervals, (a,b) -> a[1] - b[1]);
        int ans = 0;

        int curr = intervals[0][1];

        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] < curr) ans++;
            else curr = intervals[i][1];
        }



        return ans;
    }
}