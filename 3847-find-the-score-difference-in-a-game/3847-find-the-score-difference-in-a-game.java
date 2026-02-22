class Solution {
    public int scoreDifference(int[] nums) {
        int[] scores = new int[2];
        int active = 0;

        for(int i = 0; i < nums.length; i++) {

            if(nums[i] % 2 != 0) active = 1 - active;
            if(i % 6 == 5) active = 1-active;

            scores[active] += nums[i];
        }

        return scores[0] - scores[1];
    }
}