class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        helper(nums, 0, result);

        return result;
    }

    private void helper(int[] nums, int index, List<List<Integer>> result) {

        if(index == nums.length) {
            List list = new ArrayList<>();

            for(int num : nums) list.add(num);

            result.add(list);
        }

        for(int i = index; i < nums.length; i++) {
            swap(nums, i, index);
            helper(nums, index + 1, result);
            swap(nums, i, index);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}