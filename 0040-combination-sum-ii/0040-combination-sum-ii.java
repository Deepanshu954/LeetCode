class Solution {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        helper(0, nums, target, new ArrayList<>(), res);
        return res;
    }

    private void helper(int idx, int[] nums, int k, List<Integer> curr, List<List<Integer>> res) {
        if(k == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }
        if(idx < 0) return;

        for(int i = idx; i < nums.length; i++) {
            if(i > idx && nums[i-1] == nums[i]) continue;
            if(nums[i] > k) continue;

            curr.add(nums[i]);
            helper(i+1, nums, k - nums[i], curr, res);
            curr.remove(curr.size() - 1);
        }
    }
}