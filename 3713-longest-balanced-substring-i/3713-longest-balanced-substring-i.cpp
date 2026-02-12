#pragma GCC optimize("O3,unroll-loops")
#pragma GCC target("avx2,bmi,bmi2,lzcnt,popcnt")

#include <string>
#include <iostream>

using namespace std;

// Disable IO synchronization for instant startup
static const auto _ = []() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    return nullptr;
}();

class Solution {
public:
    int longestBalanced(string s) {
        // Use int for native register width (usually faster than short on 64-bit CPUs for simple arithmetic)
        const int n = s.length();
        if (n == 0) return 0;
        
        // Access string via raw pointer to bypass bounds checking
        const char* str = s.c_str();
        
        int max_len = 0;

        // Iterate over every starting position
        for (int i = 0; i < n; ++i) {
            
            // PRUNING: If even taking all remaining characters can't beat the record, stop.
            if (n - i <= max_len) break;

            // Stack-allocated frequency map (L1 Cache resident)
            // Manual loop reset is often faster than memset for small sizes due to inlining
            int cnt[26] = {0}; 
            
            int distinct = 0;
            int max_freq = 0;
            
            // PHASE 1: CATCH-UP
            // Run blindly until we reach the length of the current best record.
            // No validity checks here. Just updating state.
            int j = i;
            // We can only start checking after we cross the current max_len threshold
            int limit = i + max_len; 
            
            for (; j < limit; ++j) {
                int idx = str[j] - 'a';
                if (cnt[idx] == 0) distinct++;
                cnt[idx]++;
                if (cnt[idx] > max_freq) max_freq = cnt[idx];
            }

            // PHASE 2: RECORD BREAKING
            // Now every step extends the window beyond the previous max_len.
            // We check for balance at every step.
            for (; j < n; ++j) {
                int idx = str[j] - 'a';
                
                // Branchless-ish update for distinct count
                if (cnt[idx] == 0) distinct++;
                
                cnt[idx]++;
                // Max freq only grows, never shrinks in this direction
                if (cnt[idx] > max_freq) max_freq = cnt[idx];
                
                // Current length
                int len = j - i + 1;
                
                // Check Balance:
                // Optimization: Instead of expensive division, use multiplication.
                if (distinct * max_freq == len) {
                    max_len = len;
                    // Note: We don't break here; a longer valid substring might exist further down.
                }
            }
        }
        return max_len;
    }
};