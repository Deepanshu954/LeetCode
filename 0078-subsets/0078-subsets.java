class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        helper(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void helper(int[] nums, int index, List<Integer> curr, List<List<Integer>> result) {

        result.add(new ArrayList<>(curr));

        for(int i = index; i < nums.length; i++) {
            curr.add(nums[i]);
            helper(nums, i + 1, curr, result);
            curr.remove(curr.size() - 1);
        }

    }
}