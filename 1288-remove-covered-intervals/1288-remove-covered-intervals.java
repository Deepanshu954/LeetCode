class Solution {
    public int removeCoveredIntervals(int[][] inv) {
        int n = inv.length;

        Arrays.sort(inv, (a, b) -> {
            if(a[0] == b[0]) return b[1] - a[1];
            return a[0] - b[0];
        });

        int rem = 1;
        int[] prev = new int[2];
        prev = inv[0];

        for(int i = 1; i < n; i++) {
            if(inv[i][1] > prev[1] && inv[i][0] > prev[0]) {
                rem++;
                prev = inv[i];
            }
        }

        return rem;
    }
}