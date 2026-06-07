import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }

        // Sort intervals sequentially by their starting points
        Arrays.sort(intervals, (firstInterval, secondInterval) -> Integer.compare(firstInterval[0], secondInterval[0]));

        List<int[]> mergedList = new ArrayList<>();
        
        for (int[] currentInterval : intervals) {
            // If list is empty or there is no overlap, append the interval
            if (mergedList.isEmpty() || mergedList.get(mergedList.size() - 1)[1] < currentInterval[0]) {
                mergedList.add(currentInterval);
            } else {
                // There is an overlap, update the end time of the previous interval
                int[] lastMergedInterval = mergedList.get(mergedList.size() - 1);
                lastMergedInterval[1] = Math.max(lastMergedInterval[1], currentInterval[1]);
            }
        }

        // Correctly convert List<int[]> to int[][]
        return mergedList.toArray(new int[mergedList.size()][]);
    }
}