class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();

        for(int mask = 0; mask < (1 << n); mask++) {

            List<Integer> curr = new ArrayList<>();

            for(int i = 0; i < n; i++) {
                if((mask & (1 << i)) != 0) curr.add(nums[i]);
            }

            res.add(curr);
        }
        return res;
    }
}