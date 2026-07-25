class Solution {

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {

        int m = nums1.length;
        int n = nums2.length;

        int[] ans = new int[k];

        for (int i = Math.max(0, k - n); i <= Math.min(k, m); i++) {

            int[] a = maxSubsequence(nums1, i);
            int[] b = maxSubsequence(nums2, k - i);

            int[] candidate = merge(a, b);

            if (greater(candidate, 0, ans, 0))
                ans = candidate;
        }

        return ans;
    }

    private int[] maxSubsequence(int[] nums, int k) {

        int[] stack = new int[k];
        int top = -1;
        int remove = nums.length - k;

        for (int num : nums) {

            while (top >= 0 && stack[top] < num && remove > 0) {
                top--;
                remove--;
            }

            if (top + 1 < k) {
                stack[++top] = num;
            } else {
                remove--;
            }
        }

        return stack;
    }

    private int[] merge(int[] a, int[] b) {

        int[] res = new int[a.length + b.length];

        int i = 0, j = 0, idx = 0;

        while (i < a.length || j < b.length) {

            if (greater(a, i, b, j))
                res[idx++] = a[i++];
            else
                res[idx++] = b[j++];
        }

        return res;
    }

    private boolean greater(int[] a, int i, int[] b, int j) {

        while (i < a.length && j < b.length && a[i] == b[j]) {
            i++;
            j++;
        }

        if (j == b.length) return true;
        if (i == a.length) return false;

        return a[i] > b[j];
    }
}