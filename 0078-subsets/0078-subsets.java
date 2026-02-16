class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> p = new ArrayList<>();

        helper(nums, 0, p, res);
        return res;
    }

    private void helper(int[] nums, int index, List<Integer> p, List<List<Integer>> res) {
        if(index == nums.length) {
            res.add(new ArrayList<>(p));
            return;
        }

        int num = nums[index];

        // 1. Include the Number
        p.add(num);
        helper(nums, index + 1, p, res);

        // Backtrack
        p.remove(p.size() - 1);

        // 2. Exclude the number
        helper(nums, index + 1, p, res);
    }
}