// GCC Optimizations to force vectorization and remove safety checks
#pragma GCC optimize("Ofast,unroll-loops,no-stack-protector")
#pragma GCC target("avx2,bmi,bmi2,lzcnt,popcnt")

class Solution {
public:
    int longestBalanced(string s) {
        // 1. Capture size locally to avoid s.size() calls
        const int n = s.size();
        if (n == 0) return 0;

        // 2. Direct pointer to string data (Avoiding s[i] bounds checking)
        const char* str = s.c_str();

        int max_len = 0;

        // 3. Main Loop
        for (int i = 0; i < n; ++i) {
            
            // PRUNING: If remaining characters can't beat the record, EXIT.
            // This is the most important line for passing 1000+ test cases.
            if (n - i <= max_len) break;

            // 4. Frequency Map on Stack
            // Using 'unsigned short' is faster than 'int' on some SIMD architectures 
            // for small numbers and takes half the cache space.
            unsigned short cnt[26] = {0};
            
            int distinct = 0;
            int max_freq = 0;
            int num_with_max_freq = 0;

            // 5. Inner Loop
            for (int j = i; j < n; ++j) {
                // Raw char to index (0-25)
                int idx = str[j] - 'a';

                // Branchless-style updates
                // If count was 0, we found a new distinct char
                if (cnt[idx] == 0) {
                    distinct++;
                }

                // Increment count
                cnt[idx]++;
                int f = cnt[idx];

                // Update Max Frequency Stats
                // If this char's freq exceeds current max, it stands alone as the new max
                if (f > max_freq) {
                    max_freq = f;
                    num_with_max_freq = 1;
                } 
                // If it equals the max, it joins the club
                else if (f == max_freq) {
                    num_with_max_freq++;
                }

                // 6. Validity Check
                // Only check math if we have a candidate for a new record
                int len = j - i + 1;
                
                if (len > max_len) {
                    // MATH TRICK: 
                    // Instead of checking every character's frequency, we check:
                    // "Do the number of characters with max_freq equal the total distinct characters?"
                    // If yes, it implies NO character has a lower frequency.
                    if (distinct == num_with_max_freq) {
                        max_len = len;
                    }
                }
            }
        }
        return max_len;
    }
};