import java.util.*;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);

        Deque<Integer> dq = new ArrayDeque<>(); // store indices

        for (int i = 0; i < 2 * n; i++) {
            int idx = i % n;

            // resolve next greater
            while (!dq.isEmpty() && nums[dq.peekFirst()] < nums[idx]) {
                res[dq.removeFirst()] = nums[idx];
            }

            // push index only in first round
            if (i < n) {
                dq.addFirst(idx);
            }
        }

        return res;
    }
}