class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        Deque<Integer> dq = new ArrayDeque<>();
        int[] res = new int[n2];
        

        for(int i = n2 - 1; i >= 0; i--) {
            while(!dq.isEmpty() && dq.peekFirst() <= nums2[i]) dq.removeFirst();

            res[i] = dq.isEmpty() ? -1 : dq.peekFirst();

            dq.addFirst(nums2[i]);
        }

        int[] ans = new int[n1];

        for(int i = 0; i < n1; i++) {
            for(int j = 0; j < n2; j++) {
                if(nums1[i] == nums2[j]) ans[i] = res[j];
            }
        }
        
        return ans;
    }
}