#include <string.h>
#include <stdio.h>

// Helper macro for branch prediction (works on GCC/Clang)
#define LIKELY(x) __builtin_expect(!!(x), 1)
#define UNLIKELY(x) __builtin_expect(!!(x), 0)

int longestBalanced(char* s) {
    // 1. Localize Length
    int n = 0;
    while(s[n]) n++; // Faster than strlen in some contexts if not cached
    if (n == 0) return 0;

    // 2. Stack-Allocated Integer Map
    // Converting char to 0-25 index ONCE saves 1000s of subtractions later.
    // Using 'short' because N <= 1000 fits in 2 bytes.
    short nums[n]; 
    for(int i = 0; i < n; i++) {
        nums[i] = s[i] - 'a';
    }

    int max_len = 0;

    // 3. Main Loop
    for (int i = 0; i < n; ++i) {
        
        // PRUNING: Stop if remaining length is too small
        if (UNLIKELY(n - i <= max_len)) break;

        // 4. Frequency Array on Stack
        // Size 26 shorts = 52 bytes. Fits in ONE cache line (64 bytes).
        // Manual clearing is often faster than memset for tiny arrays.
        short cnt[26] = {0};

        int distinct = 0;
        int max_freq = 0;
        int num_max = 0;
        
        int j = i;
        
        // TRICK: "Blind" Fast-Forward
        // We know we can't beat the record until length > max_len.
        // So we run a "dumb" loop that just updates counts without checking validity.
        // This removes the "if (balanced)" check for 90% of iterations.
        int catch_up_limit = i + max_len;
        if (catch_up_limit >= n) catch_up_limit = n; // Safety cap

        // --- PHASE 1: CATCH UP (No Checks) ---
        for (; j < catch_up_limit; ++j) {
            int c = nums[j];
            
            // Logic: Update Distinct
            if (cnt[c] == 0) distinct++;
            
            // Logic: Update Freq
            cnt[c]++;
            
            // Logic: Update Max Freq
            if (cnt[c] > max_freq) {
                max_freq = cnt[c];
                num_max = 1;
            } else if (cnt[c] == max_freq) {
                num_max++;
            }
        }

        // --- PHASE 2: RECORD BREAKING (With Checks) ---
        // Now every step is a potential new record.
        for (; j < n; ++j) {
            int c = nums[j];
            
            if (cnt[c] == 0) distinct++;
            
            cnt[c]++;
            
            if (cnt[c] > max_freq) {
                max_freq = cnt[c];
                num_max = 1;
            } else if (cnt[c] == max_freq) {
                num_max++;
            }

            // CHECK: 
            // Instead of (distinct * max_freq == len), we use:
            // "Do all distinct chars have the max frequency?"
            // This is just an integer compare.
            if (num_max == distinct) {
                // Since we are in Phase 2, we know j - i + 1 > max_len
                max_len = j - i + 1;
            }
        }
    }
    return max_len;
}