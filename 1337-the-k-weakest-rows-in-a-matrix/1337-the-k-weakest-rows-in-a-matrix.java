class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (a[1] == b[1]) ? a[0] - b[0] : a[1] - b[1]);



        for(int i = 0; i < m; i++) {
            int size = matrixS(mat[i]);
            pq.offer(new int[]{i, size});
        }

        int[] res = new int[k];
        for(int i = 0; i < k; i++) {
            res[i] = pq.poll()[0];
        }

        return res;
    }

    private int matrixS(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while(left <= right) {
            int mid = left + (right - left)/2;

            if(nums[mid] == 1) left = mid + 1;
            else right = mid - 1;
        }

        return left;
    }
}