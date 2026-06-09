class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int n  = nums.length;
        int cnt = 0;
        int sum = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);

        for(int i = 0; i < n; i++) {
            int min = (int)1e9;
            int max = -1;
            for(int j = i; j < n; j++) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                
                int diff = max - min;
                pq.add(diff);
            }

            
            
        }

        long res = 0;
        while(k--> 0 && !pq.isEmpty()) {
            res += pq.poll();
        }

        return res;
    }
}