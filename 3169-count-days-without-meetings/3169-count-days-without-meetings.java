import java.util.*;

class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        int free = 0;
        int prevEnd = 0;

        for (int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];

            if (start > prevEnd + 1) {
                free += start - prevEnd - 1;
            }

            prevEnd = Math.max(prevEnd, end);
        }

        free += days - prevEnd;

        return free;
    }
}