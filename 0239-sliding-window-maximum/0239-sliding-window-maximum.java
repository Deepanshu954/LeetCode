// class Solution {
//     public int[] maxSlidingWindow(int[] nums, int k) {
//         if (nums == null || k <= 0) return new int[0];
//         int[] ans = new int[nums.length - k + 1];

//         for(int i = 0; i < nums.length - k + 1; i++){
//             int max = Integer.MIN_VALUE;

//             for(int j = i; j < i+k; j++){
//                 max = Math.max(max, nums[j]);
//             }
//             ans[i] = max;
//         }
//         return ans;
//     }
// }




class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) return new int[0];
        
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        int ri = 0;
        
        Deque<Integer> q = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
            if (!q.isEmpty() && q.peek() == i - k) q.poll();
            
            // 2. Remove elements smaller than the current element from the back
            // We maintain a decreasing order in the deque
            while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) q.pollLast();
            
            // 3. Add current element's index
            q.offer(i);
            
            // 4. Add the max to result (only if window is fully formed)
            if (i >= k - 1) ans[ri++] = nums[q.peek()];
        }
        
        return ans;
    }
}