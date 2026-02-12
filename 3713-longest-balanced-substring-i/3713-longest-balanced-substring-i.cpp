#include <string>
#include <vector>
#include <algorithm>

using namespace std;

// Optimization 1: Disable C++ Stream syncing for faster startup
static const auto _ = []() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    return nullptr;
}();

class Solution {
public:
    int longestBalanced(string s) {
        int n = s.size();
        if (n == 0) return 0;

        // Optimization 2: Convert string to integer array on the stack.
        // Accessing 'arr[i]' is faster than 's[i]' or 's.at(i)'.
        // Using 'short' saves cache bandwidth.
        short arr[1005]; 
        for (int i = 0; i < n; ++i) {
            arr[i] = s[i] - 'a';
        }

        int max_len = 0;

        for (int i = 0; i < n; ++i) {
            // Pruning: If remaining characters are fewer than current max, give up.
            if (n - i <= max_len) break;

            // Frequency array on stack. 
            // We use 'short' because counts <= 1000 fits easily.
            short cnt[26] = {0}; 
            
            int distinct = 0;
            int max_freq = 0;

            // Optimization 3: Split the Inner Loop
            // PART A: "Catch Up" Loop
            // We know we can't beat 'max_len' until j reaches 'i + max_len'.
            // So we run this loop purely to build the 'cnt' state without checking validity.
            // This removes thousands of "if (check)" instructions.
            int j = i;
            int limit = min(n, i + max_len);
            
            for (; j < limit; ++j) {
                int c = arr[j];
                if (cnt[c] == 0) distinct++;
                cnt[c]++;
                if (cnt[c] > max_freq) max_freq = cnt[c];
            }

            // PART B: "Record Breaking" Loop
            // Now we are in uncharted territory (length > max_len).
            // We check validity at every step.
            for (; j < n; ++j) {
                int c = arr[j];
                if (cnt[c] == 0) distinct++;
                cnt[c]++;
                if (cnt[c] > max_freq) max_freq = cnt[c];

                // Since we are strictly > max_len here, we just check validity.
                // Logic: if (Distinct * MaxFreq == Length)
                if (distinct * max_freq == (j - i + 1)) {
                    max_len = j - i + 1;
                }
            }
        }
        return max_len;
    }
};