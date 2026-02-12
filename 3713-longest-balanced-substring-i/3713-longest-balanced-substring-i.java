class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        if (n == 0) return 0;

        // Optimization: Convert to char array for faster indexing
        char[] chars = s.toCharArray();
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            // Pruning: If remaining length is less than current best, stop.
            if (n - i <= maxLen) {
                break;
            }

            int[] counts = new int[26];
            int distinct = 0;
            int maxFreq = 0;

            for (int j = i; j < n; j++) {
                int idx = chars[j] - 'a';

                if (counts[idx] == 0) {
                    distinct++;
                }
                counts[idx]++;
                
                // Track max frequency
                if (counts[idx] > maxFreq) {
                    maxFreq = counts[idx];
                }

                // Check condition: Max Freq * Distinct Count == Window Length
                int len = j - i + 1;
                if (maxFreq * distinct == len) {
                    if (len > maxLen) {
                        maxLen = len;
                    }
                }
            }
        }
        return maxLen;
    }
}