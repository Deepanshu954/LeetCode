class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);

        for(int s : stones) pq.add(s);
        int ans = 0;

        while(pq.size() > 1) {
            int s1 = pq.poll();
            int s2 = pq.poll();

            if(s1 == s2) continue;
            
            ans = Math.abs(s1 - s2);
            pq.offer(ans);
        }

        return pq.poll();
    }
}