class Solution {
    public boolean containsDuplicate(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();

        // for(int num : nums) {
        //     if(set.contains(num)) return true;

        //     set.add(num);
        // }

        for(int i = 0; i < 500; i++) {
            if(set.contains(nums[i])) return true;
            if(i == n- 1) return false;

            set.add(nums[i]);
        }

        return false;
    }
}