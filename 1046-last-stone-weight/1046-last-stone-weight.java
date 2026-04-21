class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int s : stones) pq.offer(s);

        return pq.poll();
    }
}