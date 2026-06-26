class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        // int[] rangeSum = new int[n];

        int cnt = 0;
        int res = 0;
        for(int i = 0; i < n; i++) {
            cnt = 0;
            for(int j = i; j < n; j++) {
                if(nums[j] == target) cnt++;

                int len = j - i + 1;
                if(len < 2*cnt) res++;
            }
        }

        return res;
    }
}