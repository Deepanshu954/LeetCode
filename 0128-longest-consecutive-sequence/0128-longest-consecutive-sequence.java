class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();

        // store
        for(int i = 0; i < n; i++) {
            set.add(nums[i]);
        }

        // find start and calculate size
        int res = 0;
        for(int i = 0; i < n; i++) {
            if(set.contains(nums[i] - 1)) continue;

            int start = nums[i];
            int index = 0;
            while(set.contains(start++)) index++;

            res = Math.max(res, index);
        }

        return res;
    }
}