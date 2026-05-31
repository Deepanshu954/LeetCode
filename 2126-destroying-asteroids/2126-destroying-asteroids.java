class Solution {
    public boolean asteroidsDestroyed(int k, int[] nums) {
        Arrays.sort(nums);
        int tar = k;

        for(int num : nums) {
            if(num <= tar) {
                tar += num;
            } else {
                return false;
            }
        }

        return true;
    }
}