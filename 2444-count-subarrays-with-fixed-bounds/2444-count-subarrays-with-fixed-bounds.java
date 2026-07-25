class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long cnt = 0;

        int lastMin = -1;
        int lastMax = -1;
        int lastBad = -1;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] < minK || nums[i] > maxK) lastBad = i;
            if(nums[i] == minK) lastMin = i;
            if(nums[i] == maxK) lastMax = i;

            cnt += Math.max(0, Math.min(lastMin, lastMax) - lastBad);
        }

        return cnt;
    }
}