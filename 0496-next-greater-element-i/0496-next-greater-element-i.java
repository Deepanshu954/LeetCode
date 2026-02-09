class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        Deque<Integer> dq = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = n2 - 1; i >= 0; i--) {
            while(!dq.isEmpty() && dq.peekFirst() <= nums2[i]) dq.removeFirst();

            map.put(nums2[i], dq.isEmpty() ? -1 : dq.peekFirst());

            dq.addFirst(nums2[i]);
        }

        int[] ans = new int[n1];

        for(int i = 0; i < n1; i++) {
            ans[i] = map.get(nums1[i]);
        }
        return ans;
    }
}