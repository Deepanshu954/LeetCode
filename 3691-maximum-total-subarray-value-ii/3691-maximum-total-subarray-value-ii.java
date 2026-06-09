import java.util.*;

class Solution {
    // Sparse tables for O(1) range maximum and minimum queries
    int[][] maxST;
    int[][] minST;
    int[] lg;

    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;
        initSparseTables(nums, n);

        // Max-heap stores state: [value, L, R]
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(b[0], a[0]));
        
        // Track visited subarray intervals to prevent duplicates
        Set<Long> visited = new HashSet<>();

        // Start with the absolute maximum interval (entire array)
        long initialVal = getRangeValue(0, n - 1);
        pq.add(new long[]{initialVal, 0, n - 1});
        visited.add(encode(0, n - 1));

        long totalMaxSum = 0;

        // Extract the top-k highest range values dynamically
        while (k > 0 && !pq.isEmpty()) {
            long[] curr = pq.poll();
            long val = curr[0];
            int l = (int) curr[1];
            int r = (int) curr[2];

            totalMaxSum += val;
            k--;

            // Try shrinking from the left
            if (l + 1 <= r) {
                long codeL = encode(l + 1, r);
                if (!visited.contains(codeL)) {
                    visited.add(codeL);
                    pq.add(new long[]{getRangeValue(l + 1, r), l + 1, r});
                }
            }

            // Try shrinking from the right
            if (l <= r - 1) {
                long codeR = encode(l, r - 1);
                if (!visited.contains(codeR)) {
                    visited.add(codeR);
                    pq.add(new long[]{getRangeValue(l, r - 1), l, r - 1});
                }
            }
        }

        return totalMaxSum;
    }

    // O(1) calculation of Subarray Value: max - min
    private long getRangeValue(int l, int r) {
        int k = lg[r - l + 1];
        int maxVal = Math.max(maxST[l][k], maxST[r - (1 << k) + 1][k]);
        int minVal = Math.min(minST[l][k], minST[r - (1 << k) + 1][k]);
        return (long) maxVal - minVal;
    }

    // Standard Sparse Table initialization: O(n log n)
    private void initSparseTables(int[] nums, int n) {
        lg = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            lg[i] = lg[i / 2] + 1;
        }

        int K = lg[n] + 1;
        maxST = new int[n][K];
        minST = new int[n][K];

        for (int i = 0; i < n; i++) {
            maxST[i][0] = nums[i];
            minST[i][0] = nums[i];
        }

        for (int j = 1; j < K; j++) {
            for (int i = 0; i + (1 << j) <= n; i++) {
                maxST[i][j] = Math.max(maxST[i][j - 1], maxST[i + (1 << (j - 1))][j - 1]);
                minST[i][j] = Math.min(minST[i][j - 1], minST[i + (1 << (j - 1))][j - 1]);
            }
        }
    }

    // Helper to safely pack two 32-bit indices into a single 64-bit Long
    private long encode(int l, int r) {
        return ((long) l << 32) | (r & 0xFFFFFFFFL);
    }
}
