class Solution {
    public int removeCoveredIntervals(int[][] inv) {
        int n = inv.length;

        Arrays.sort(inv, (a, b) -> {
            if(a[0] == b[0]) return b[1] - a[1];
            return a[0] - b[0];
        });

        int rem = 1;
        int prev = inv[0][1];

        for(int i = 1; i < n; i++) {
            if(inv[i][1] > prev) {
                rem++;
                prev = inv[i][1];
            }
        }

        return rem;
    }
}