class Solution {
    public int removeCoveredIntervals(int[][] inv) {

        Arrays.sort(inv, (a, b) -> {
            if(a[0] == b[0]) return b[1] - a[1];
            return a[0] - b[0];
        });

        int rem = 0;
        int currEnd = 0;

        for(int[] interval : inv) {
            if(interval[1] > currEnd) {
                rem++;                  // not covered
                currEnd = interval[1];
            }
        }

        return rem;
    }
}