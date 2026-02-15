class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;

        // 1. Stroing Answer
        List<List<Integer>> res = new ArrayList<>();

        // 2. Loop Over all the possible bitmask
        for(int mask = 0; mask < (1 << n); mask++) {
            ArrayList<Integer> curr = new ArrayList<>();

            // 3. Taking required element 
            for(int i = 0; i < n; i++) {
                if((mask & (1 << i)) != 0) curr.add(nums[i]);
            }

            res.add(curr);
        }
        
        return res;
    }
}