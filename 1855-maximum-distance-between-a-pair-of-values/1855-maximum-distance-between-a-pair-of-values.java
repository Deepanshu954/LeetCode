class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int left = 0;
        int right = 0;

        int dist = 0;

        while(left < n && right < m) {
            if(left <= right) {
                if(nums1[left] <= nums2[right]) {
                    dist = Math.max(dist, right - left);
                    right++;
                } else left++;

            } else right++;
        }


        return dist;
    }
}