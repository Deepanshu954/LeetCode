class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        // Group indices by their values
        for(int i = 0; i < n; i++) {
            // Using computeIfAbsent is cleaner than containsKey + put
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        long[] res = new long[n];

        for(int i = 0; i < n; i++) {
            int val = nums[i];
            List<Integer> indices = map.get(val);
            
            if (indices.size() == 1) {
                res[i] = 0;
                continue;
            }

            long sum = 0;
            for(int indexInList : indices) {
                sum += Math.abs((long)indexInList - i);
            }
            res[i] = sum;
        }

        return res;
    }
}
