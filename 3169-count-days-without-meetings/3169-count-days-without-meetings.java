class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        int free = 0;
        int prev = 0;

        for (int[] meet : meetings) {
            if (meet[0] > prev + 1) {
                free += meet[0] - prev - 1;
            }

            prev = Math.max(prev, meet[1]);
        }

        return free + days - prev;
    }
}