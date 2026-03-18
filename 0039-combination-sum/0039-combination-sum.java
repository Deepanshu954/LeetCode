class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        helper(candidates, 0, new ArrayList<>(), target, result);
        return result;
    }

    private void helper(int[] nums, int index, List<Integer> curr, int target, List<List<Integer>> result) {

        if(index == nums.length) {
            if(target == 0) result.add(new ArrayList<>(curr));
            return;
        }

        if(nums[index] <= target) {
            curr.add(nums[index]);
            helper(nums, index, curr, target - nums[index], result); 
            curr.remove(curr.size() - 1);
        }

        helper(nums, index + 1, curr, target, result); 

    }
}