class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> result = new ArrayList<>();
        helper(candidates, 0, target, new ArrayList<>(), result);
        return result;
    }

    private void helper(int[] nums, int index, int target, List<Integer> curr, List<List<Integer>> result) {
        if(target == 0) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for(int i = index; i < nums.length; i++) {
            if(i > index && nums[i-1] == nums[i]) continue;
            if(nums[i] > target) break;

            curr.add(nums[i]);
            helper(nums, i + 1, target - nums[i], curr, result);
            curr.remove(curr.size() - 1);
        }
    }
}