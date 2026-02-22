import java.util.*;

class Solution {
    public int largestRectangleArea(int[] heights) {

        int n = heights.length;
        Deque<Integer> dq = new ArrayDeque<>();
        int maxArea = 0;

        for (int i = 0; i <= n; i++) {

            int currHeight = (i == n) ? 0 : heights[i];

            while (!dq.isEmpty() && heights[dq.peekFirst()] > currHeight) {

                int h = heights[dq.removeFirst()];

                int rightBoundary = i;
                int leftBoundary = dq.isEmpty() ? -1 : dq.peekFirst();

                int width = rightBoundary - leftBoundary - 1;

                maxArea = Math.max(maxArea, h * width);
            }

            dq.addFirst(i);
        }

        return maxArea;
    }
}