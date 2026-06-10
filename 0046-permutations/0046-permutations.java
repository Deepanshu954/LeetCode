class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        helper(0, nums, res);
        return res;
    }

    private void helper(int idx, int[] nums, List<List<Integer>> res) {
        if(idx == nums.length) {
            List<Integer> curr = new ArrayList<>();
            for(int num : nums) curr.add(num);
            res.add(curr);
        }

        for(int i = idx; i < nums.length; i++) {
            swap(nums, i, idx);
            helper(idx+1, nums, res);
            swap(nums, i,idx);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}