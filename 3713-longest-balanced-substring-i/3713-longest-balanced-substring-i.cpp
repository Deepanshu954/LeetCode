#pragma GCC optimize("O3")
#pragma GCC target("avx2,bmi,bmi2,popcnt,lzcnt")

#include <string>
#include <vector>
#include <cstring>
#include <algorithm>

using namespace std;

// Global buffer to avoid repeated allocation on the Heap
// LeetCode reuses the solution instance, so we can use static/global arrays safely
// assuming we overwrite them.
static int val[1005]; 

class Solution {
public:
    int longestBalanced(string s) {
        int n = s.size();
        
        // Convert string to 0-25 integers once
        for (int i = 0; i < n; ++i) {
            val[i] = s[i] - 'a';
        }

        int ans = 0;

        for (int i = 0; i < n; ++i) {
            // Pruning 1: If the remaining substring is shorter than our best answer, stop.
            if (n - i <= ans) break;

            // Stack-allocated frequency array (Zero overhead)
            int cnt[26] = {0}; 
            
            int distinct = 0;
            int max_freq = 0;

            // Inner loop
            for (int j = i; j < n; ++j) {
                int c = val[j];
                
                // Update distinct count
                if (cnt[c] == 0) distinct++;
                
                // Update frequency
                cnt[c]++;
                // Optimization: Frequency only increases by 1, so if it exceeds max,
                // it can only be max_freq + 1.
                if (cnt[c] > max_freq) max_freq++;

                int len = j - i + 1;

                // Pruning 2: The "Fast Forward"
                // The CPU Branch Predictor will eventually learn that this is FALSE
                // for the first 'ans' iterations, skipping the logic inside entirely.
                if (len > ans) {
                     // Check Balance: If (Unique Chars * Max Frequency) == Total Length
                     // Then ALL unique characters must have frequency == Max Frequency
                    if (distinct * max_freq == len) {
                        ans = len;
                    }
                }
            }
        }
        return ans;
    }
};