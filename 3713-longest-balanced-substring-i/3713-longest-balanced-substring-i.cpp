#pragma GCC optimize("Ofast,no-stack-protector,unroll-loops,fast-math")
#pragma GCC target("sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,avx2,fma")

#include <iostream>
#include <string>
#include <vector>
#include <cstring>
#include <algorithm>

using namespace std;

// Disable IO syncing for speed
static const int _ = []() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    return 0;
}();

class Solution {
public:
    int longestBalanced(string s) {
        // Use short to save cache space (N <= 1000 fits in short)
        const int n = s.length();
        if (n == 0) return 0;
        
        // Raw pointer for direct memory access
        const char* str = s.c_str();
        
        // Global best result
        int ans = 0;

        // Use a flat stack-allocated buffer.
        // We do NOT use vector. We do NOT use new/malloc.
        unsigned short cnt[26];

        for (int i = 0; i < n; ++i) {
            // Pruning: Stop if we can't beat the current record
            // __builtin_expect tells compiler this branch is UNLIKELY to be taken
            if (__builtin_expect(n - i <= ans, 0)) break;

            // Reset freq array - for small arrays, loop unrolling is faster than memset
            // But with AVX enabled, memset is 1 instruction.
            memset(cnt, 0, sizeof(cnt));

            int distinct = 0;
            int max_freq = 0;
            int num_with_max_freq = 0;
            
            // Inner loop
            for (int j = i; j < n; ++j) {
                // 1. Calculate Index (0-25)
                // Use raw char subtraction.
                int idx = str[j] - 'a';

                // 2. Update Distinct Count
                // Branchless logic: (cnt[idx] == 0) is 1 or 0.
                distinct += (cnt[idx] == 0);

                // 3. Update Frequency
                int freq = ++cnt[idx];

                // 4. Update Max Frequency stats
                // This logic is tricky to make fully branchless, but we can hint it.
                if (freq > max_freq) {
                    max_freq = freq;
                    num_with_max_freq = 1;
                } else {
                    // Branchless add: if freq == max_freq add 1, else add 0
                    num_with_max_freq += (freq == max_freq);
                }

                // 5. Length calculation
                int len = j - i + 1;

                // 6. Validity Check
                // Only check if we have surpassed the previous best length.
                // We shield the expensive check with (len > ans).
                if (len > ans) {
                    // Check: Do all distinct characters have the same frequency?
                    // This is true if: Count of chars with max_freq == Total distinct chars
                    if (num_with_max_freq == distinct) {
                        ans = len;
                    }
                }
            }
        }
        return ans;
    }
};