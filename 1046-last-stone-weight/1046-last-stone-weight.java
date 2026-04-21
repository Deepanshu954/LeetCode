class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a,b) -> b - a
        );

        for(int s : stones) pq.offer(s);

        while(pq.size() > 1) {
            int s1 = pq.poll();
            int s2 = pq.poll();

            int abs = Math.abs(s1 - s2);
            pq.offer(abs);
        }

        return pq.poll();
    }
}