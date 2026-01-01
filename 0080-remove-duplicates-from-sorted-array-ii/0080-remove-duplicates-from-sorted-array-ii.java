class Solution {
    public int removeDuplicates(int[] nums) {
        int index = 1;
        int enc = 1;
        int prev = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == prev) {
                if (enc == 2) continue;
                enc++;
            } else {
                prev = nums[i];
                enc = 1;
            }
            nums[index++] = nums[i];
        }
        return index;
    }
}