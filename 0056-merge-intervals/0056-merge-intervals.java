class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0) return new int[0][];

        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        int index = 0;

        for(int i = 1; i < intervals.length; i++) {

            if(intervals[index][0] > intervals[i][0]) {
                intervals[index][1] = Math.max(intervals[index][0] , intervals[i][1]);
            } else {
                index++;
                intervals[index] = intervals[i];
            }
        }
        
        return Arrays.copyOfRange(intervals, 0, index + 1);
    }
}