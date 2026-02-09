class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);

        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 2 * n - 1; i >= 0; i--) {
            int idx = i % n;

            while (!dq.isEmpty() && dq.peekFirst() <= nums[idx]) {
                dq.removeFirst();
            }

            if (i < n) {
                res[idx] = dq.isEmpty() ? -1 : dq.peekFirst();
            }

            dq.addFirst(nums[idx]);
        }
        
        return res;
    }
}