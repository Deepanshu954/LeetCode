#pragma GCC optimize("O3")
#pragma GCC target("avx2,bmi,bmi2,popcnt,lzcnt")

#include <string>
#include <algorithm>
#include <cstring>

class Solution {
public:
    int longestBalanced(string s) {
        int n = s.size();
        if (n == 0) return 0;
        
        // OPTIMIZATION 1: Use raw stack array instead of vector for speed.
        // Assumes N <= 2500 based on typical "easy/medium" brute force constraints.
        // If N is larger, allocate a vector outside the loop once.
        int a[2500]; 
        for (int i = 0; i < n; ++i) a[i] = s[i] - 'a';

        int result = 0;

        for (int l = 0; l < n; ++l) {
            // Pruning: if remaining chars aren't enough to beat the record, stop.
            if (n - l <= result) break;

            int cnt[26] = {0};
            int uniq = 0;
            int maxfreq = 0;
            int num_with_max = 0; // Tracks how many chars share the max frequency

            int r = l;
            
            // OPTIMIZATION 2: "Fast Forward"
            // Don't waste CPU cycles checking validity for substrings shorter 
            // than what we've already found. Just update stats.
            int limit = min(n, l + result);
            
            for (; r < limit; ++r) {
                int c = a[r];
                if (cnt[c] == 0) uniq++;
                
                cnt[c]++;
                if (cnt[c] > maxfreq) {
                    maxfreq = cnt[c];
                    num_with_max = 1; // New max established, count resets to 1
                } else if (cnt[c] == maxfreq) {
                    num_with_max++;   // Another char caught up to maxfreq
                }
            }

            // OPTIMIZATION 3: Check Phase
            // Now we are in "record breaking" territory. Check every step.
            for (; r < n; ++r) {
                int c = a[r];
                if (cnt[c] == 0) uniq++;
                
                cnt[c]++;
                
                // Update Max Frequency stats
                if (cnt[c] > maxfreq) {
                    maxfreq = cnt[c];
                    num_with_max = 1;
                } else if (cnt[c] == maxfreq) {
                    num_with_max++;
                }

                // Logic Check: simpler than (maxfreq * uniq == len)
                // If the number of chars sharing max_freq is equal to total unique chars,
                // it implies all unique chars have the same frequency.
                if (num_with_max == uniq) {
                    result = r - l + 1;
                }
            }
        }
        return result;
    }
};