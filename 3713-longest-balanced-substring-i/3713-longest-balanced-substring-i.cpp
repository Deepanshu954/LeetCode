#include <string>
using namespace std;

class Solution {
public:
    int longestBalanced(string s) {
        int n = s.size();
        int ans = 0;

        for (int i = 0; i < n; ++i) {
            int freq[26] = {0};
            int distinct = 0;
            int maxFreq = 0;

            for (int j = i; j < n; ++j) {
                int c = s[j] - 'a';
                if (freq[c] == 0) distinct++;
                freq[c]++;
                maxFreq = max(maxFreq, freq[c]);

                int len = j - i + 1;
                if (distinct * maxFreq == len) {
                    ans = max(ans, len);
                }
            }
        }

        return ans;
    }
};