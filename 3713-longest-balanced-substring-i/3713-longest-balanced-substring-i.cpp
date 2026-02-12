#include <string>
using namespace std;

class Solution {
public:
    int longestBalanced(string s) {
        int n = s.size();
        int ans = 0;

        for (int d = 1; d <= 26; ++d) {
            int freq[26] = {0};
            int left = 0;
            int distinct = 0;
            int maxFreq = 0;

            for (int right = 0; right < n; ++right) {
                int r = s[right] - 'a';
                if (freq[r] == 0) distinct++;
                freq[r]++;
                maxFreq = max(maxFreq, freq[r]);

                while (distinct > d) {
                    int l = s[left] - 'a';
                    freq[l]--;
                    left++;
                    distinct = 0;
                    maxFreq = 0;
                    for (int i = 0; i < 26; ++i) {
                        if (freq[i] > 0) {
                            distinct++;
                            maxFreq = max(maxFreq, freq[i]);
                        }
                    }
                }

                int len = right - left + 1;
                if (distinct == d && distinct * maxFreq == len) {
                    ans = max(ans, len);
                }
            }
        }

        return ans;
    }
};