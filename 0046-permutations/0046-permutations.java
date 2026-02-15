class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(nums, 0, nums.length - 1, res);
        return res;
    }

    private void helper(int[] nums, int left, int right, List<List<Integer>> res) {
        if(left == right) {

            List<Integer> list = new ArrayList<>();
            for(int num : nums) list.add(num);
            res.add(list);
            
        }
        else {
            for(int i = left; i <= right; i++) {
                swap(nums, left, i); // Choose
                helper(nums, left + 1, right, res); // Explore
                swap(nums,left, i); // Undo
            }
        }
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}