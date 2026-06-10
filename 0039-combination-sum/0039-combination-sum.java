class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();

        helper(0, nums, target, new ArrayList<>(), res);
        return res;
    }

    private void helper(int idx, int[] nums, int k, List<Integer> curr, List<List<Integer>> res) {
        if(k == 0) res.add(new ArrayList<>(curr));
        if(idx < 0) return;

        for(int i = idx; i < nums.length; i++) {
            if(nums[i] > k) continue;
            curr.add(nums[i]);
            helper(i, nums, k - nums[i], curr, res);
            curr.remove(curr.size() - 1);
        }
    }
}