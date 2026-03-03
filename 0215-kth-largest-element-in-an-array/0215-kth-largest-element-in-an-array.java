class Solution {
    public int findKthLargest(int[] nums, int k) {
        //PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        Arrays.sort(nums);

        return nums[nums.length - k ];


    }
}