class Solution {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);

        helper(0, nums, target, new ArrayList<>(), res);
        List<List<Integer>> result = new ArrayList<>(res);
        return result;
    }

    private void helper(int idx, int[] nums, int k, List<Integer> curr, Set<List<Integer>> res) {
        if(k == 0) res.add(new ArrayList<>(curr));
        if(idx < 0) return;

        for(int i = idx; i < nums.length; i++) {
            curr.add(nums[i]);
            helper(i+1, nums, k - nums[i], curr, res);
            curr.remove(curr.size() - 1);
        }
    }
}