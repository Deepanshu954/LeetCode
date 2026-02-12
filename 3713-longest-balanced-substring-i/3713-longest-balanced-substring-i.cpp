#pragma GCC optimize("Ofast,unroll-loops")
#pragma GCC target("avx2,bmi,bmi2,lzcnt,popcnt")

#include <string>
#include <vector>
#include <cstring>
#include <algorithm>

using namespace std;

// Disable C++ IO synchronization for instant startup
static const auto io_sync_off = []() {
    std::ios::sync_with_stdio(false);
    std::cin.tie(nullptr);
    return nullptr;
}();

class Solution {
public:
    int longestBalanced(string s) {
        // Use `short` for length/counts as N <= 1000. 
        // This keeps data compact in registers.
        const int n = s.length();
        if (n == 0) return 0;

        // Access raw C-string pointer for fastest possible read speeds
        const char* str = s.c_str();
        
        int max_len = 0;

        // Outer loop: Start position
        for (int i = 0; i < n; ++i) {
            
            // Pruning: If we can't possibly beat the record, stop instantly.
            if (n - i <= max_len) break;

            // Frequency map on stack.
            // Using `unsigned char` or `short` fits in fewer cache lines than `int`.
            unsigned short cnt[26] = {0}; 
            
            // Registers for inner loop state
            int distinct = 0;
            int max_freq = 0;
            int num_with_max_freq = 0;

            // Inner Loop
            for (int j = i; j < n; ++j) {
                // Raw pointer arithmetic: fast access
                int idx = str[j] - 'a';
                
                // 1. Update Distinct Count
                // Branchless-ish update: Only increments if cnt[idx] was 0
                if (cnt[idx] == 0) distinct++;
                
                // 2. Increment Frequency
                cnt[idx]++;
                int cur_freq = cnt[idx];

                // 3. Update Max Frequency Stats
                // We track `num_with_max_freq`: How many chars share the title of "most frequent"?
                if (cur_freq > max_freq) {
                    // New record set by this char. 
                    // It is now the ONLY char with this frequency.
                    max_freq = cur_freq;
                    num_with_max_freq = 1; 
                } else if (cur_freq == max_freq) {
                    // This char just caught up to the current max.
                    num_with_max_freq++;
                }

                // 4. Validity Check
                // Length of current substring
                int len = j - i + 1;

                // Optimization: Shield the check. 
                // Only check validity if this substring is longer than our best.
                if (len > max_len) {
                    // The "Multiplication-Free" Check:
                    // A substring is balanced if ALL distinct characters appear `max_freq` times.
                    // This implies: count of chars with max_freq == total distinct chars.
                    if (num_with_max_freq == distinct) {
                        max_len = len;
                    }
                }
            }
        }
        return max_len;
    }
};