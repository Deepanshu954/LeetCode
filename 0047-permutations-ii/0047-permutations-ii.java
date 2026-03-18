class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        helper(nums, 0, result);
        return result;
    }

    private void helper(int[] nums, int index, List<List<Integer>> result) {

        if(index == nums.length) {
            List<Integer> curr = new ArrayList<>();

            for(int num : nums) curr.add(num);

            result.add(curr);
            return;
        }

        Set<Integer> used = new HashSet<>();
 
        for(int i = index; i < nums.length; i++) {
            if(used.contains(nums[i])) continue;
            used.add(nums[i]);

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