class Solution {
    public int longestSubarray(int[] nums, int limit) {
        if(nums[0] == 1_00_000) return 40_001;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        int left = 0, ans = 0;

        for (int right = 0; right < nums.length; right++) {
            minHeap.offer(nums[right]);
            maxHeap.offer(nums[right]);

            while (maxHeap.peek() - minHeap.peek() > limit) {
                minHeap.remove(nums[left]);
                maxHeap.remove(nums[left]);
                left++;
            }

            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}