// class Solution {
//     public int[] maxSlidingWindow(int[] nums, int k) {
//         int n = nums.length;
//         int size = n - k + 1;
//         int[] ans = new int[size];

//         int[] window = new int[k];
//         for (int i = 0; i < size; i++) {
//             int max = -99999;

//             for (int j = i; j < i + k; j++) {
//                 if (nums[j] > max) {
//                     max = nums[j];
//                 }
//             }
//             ans[i] = max;
//         }

//         return ans;

//     }
// }



class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if(n == 0 || k == 0) return new int[0];

        int[] ans = new int[n - k + 1];

        Deque<Integer> dq = new ArrayDeque<>();

        for(int i = 0; i < n; i++){
            if(!dq.isEmpty() && dq.peekFirst() <= i - k) dq.pollFirst();

            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) dq.pollLast();

            dq.offerLast(i);

            if(i >= k - 1) ans[i-k+1] = nums[dq.peekFirst()];
        }

        return ans;
        
    }
}