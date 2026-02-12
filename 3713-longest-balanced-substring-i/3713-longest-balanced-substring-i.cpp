class Solution {
public:
    int longestBalanced(string s) {
        int n = s.length();
        if (n == 0) return 0;

        // 1. Access raw memory for maximum read speed
        const char* str = s.c_str(); 
        
        int maxLen = 0;
        
        // 2. Allocate on Stack (L1 Cache friendly)
        // 'counts' is small enough to fit in the fastest CPU cache tier.
        int counts[26]; 

        for (int i = 0; i < n; ++i) {
            // Pruning: If remaining chars can't beat record, STOP immediately.
            if (n - i <= maxLen) break;

            // 3. Ultra-fast reset using memset (often 1-2 CPU cycles via SIMD)
            memset(counts, 0, sizeof(counts));
            
            int distinct = 0;
            int maxFreq = 0;
            
            for (int j = i; j < n; ++j) {
                // Raw byte access
                int val = str[j] - 'a';
                
                // 4. Branchless optimization attempt
                // Updates distinct count without a jump instruction if compiler optimizes
                if (counts[val] == 0) distinct++;
                
                counts[val]++;
                
                // Track max frequency
                if (counts[val] > maxFreq) maxFreq = counts[val];
                
                int len = j - i + 1;
                
                // The check
                if (maxFreq * distinct == len) {
                    if (len > maxLen) maxLen = len;
                }
            }
        }
        return maxLen;
    }
};