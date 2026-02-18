class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        helper(nums, 0, new ArrayList<>(), result);

        return result;
    }

    private void helper(int[] nums, int index, List<Integer> unp, List<List<Integer>> result) {
        result.add(new ArrayList<>(unp));

        for(int i = index; i < nums.length; i++) {
            unp.add(nums[i]);
            helper(nums, i + 1, unp, result);
            unp.remove(unp.size() - 1);
        }
    }
}