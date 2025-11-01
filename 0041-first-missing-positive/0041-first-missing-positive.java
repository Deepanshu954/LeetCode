class Solution {
    public int firstMissingPositive(int[] nums) {

        Set<Integer> set = new HashSet<>();
        //if(nums.length == 1 && nums[0] == 1) return 2;
        
        for(int num : nums) set.add(num);

        for(int i = 1; i <= nums.length; i++)
        {
            if(!set.contains(i)) return i;
        }
        
        return nums.length;
    }
}