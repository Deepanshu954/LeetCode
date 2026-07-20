class Solution {

    public int minimumDifference(int[] nums) {
        int n = nums.length;
        int m = n / 2;

        int total = 0;
        for (int x : nums) total += x;

        List<Integer>[] left = new ArrayList[m + 1];
        List<Integer>[] right = new ArrayList[m + 1];

        for (int i = 0; i <= m; i++) {
            left[i] = new ArrayList<>();
            right[i] = new ArrayList<>();
        }

        // Generate subset sums
        for (int mask = 0; mask < (1 << m); mask++) {
            int cnt = 0;
            int sumL = 0;
            int sumR = 0;

            for (int j = 0; j < m; j++) {
                if ((mask & (1 << j)) != 0) {
                    cnt++;
                    sumL += nums[j];
                    sumR += nums[j + m];
                }
            }

            left[cnt].add(sumL);
            right[cnt].add(sumR);
        }

        // Sort right sums
        for (int i = 0; i <= m; i++) {
            Collections.sort(right[i]);
        }

        int ans = Integer.MAX_VALUE;

        for (int k = 0; k <= m; k++) {

            List<Integer> leftList = left[k];
            List<Integer> rightList = right[m - k];

            for (int s1 : leftList) {

                // Want s1 + s2 as close as possible to total/2
                double target = total / 2.0 - s1;

                int idx = Collections.binarySearch(rightList, (int)Math.ceil(target));

                if (idx < 0) idx = -idx - 1;

                if (idx < rightList.size()) {
                    int subset = s1 + rightList.get(idx);
                    ans = Math.min(ans, Math.abs(total - 2 * subset));
                }

                if (idx > 0) {
                    int subset = s1 + rightList.get(idx - 1);
                    ans = Math.min(ans, Math.abs(total - 2 * subset));
                }
            }
        }

        return ans;
    }
}