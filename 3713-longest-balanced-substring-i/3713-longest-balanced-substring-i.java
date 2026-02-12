import java.util.Arrays;

class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        int maxLen = 0;
        
        // Single allocation reused throughout execution
        // Space Complexity: O(1) auxiliary (fixed size 26)
        int[] counts = new int[26];

        for (int i = 0; i < n; i++) {
            // Reset the buffer manually (faster than re-allocation)
            Arrays.fill(counts, 0);
            
            int distinct = 0;
            int maxFreq = 0;

            for (int j = i; j < n; j++) {
                // Use charAt to avoid allocating a new char[] array
                int idx = s.charAt(j) - 'a';

                if (counts[idx] == 0) {
                    distinct++;
                }
                counts[idx]++;
                
                if (counts[idx] > maxFreq) {
                    maxFreq = counts[idx];
                }

                int len = j - i + 1;
                
                // If balanced, update maxLen
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