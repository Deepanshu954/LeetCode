class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);

        Deque<Integer> dq = new ArrayDeque<>();

        for(int i = 0; i < 2 * n; i++) {
            int index = i % n;

            while(!dq.isEmpty() && nums[dq.peekFirst()] < nums[index]) {
                res[dq.removeFirst()] = nums[index];
            }

            if(i < n) dq.addFirst(index);
        }
        return res;
    }
}