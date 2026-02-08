import java.util.*;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int n2 = nums2.length;
        Deque<Integer> dq = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();

        // Step 1: Next Greater for nums2
        for (int i = n2 - 1; i >= 0; i--) {

            while (!dq.isEmpty() && dq.peekFirst() <= nums2[i]) {
                dq.removeFirst();
            }

            map.put(nums2[i], dq.isEmpty() ? -1 : dq.peekFirst());
            dq.addFirst(nums2[i]);
        }

        // Step 2: Build answer for nums1
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.get(nums1[i]);
        }

        return ans;
    }
}