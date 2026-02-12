#include <string>
#include <vector>
using namespace std;

class Solution {
public:
    int longestBalanced(string s) {
        int n = s.size();
        int ans = 0;

        for (int targetDistinct = 1; targetDistinct <= 26; ++targetDistinct) {

            int freq[26] = {0};
            int left = 0, right = 0;
            int distinct = 0;
            int maxFreq = 0;

            while (right < n) {
                int r = s[right] - 'a';
                if (freq[r] == 0) distinct++;
                freq[r]++;
                maxFreq = max(maxFreq, freq[r]);
                right++;

                while (distinct > targetDistinct) {
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

                int len = right - left;
                if (distinct == targetDistinct && distinct * maxFreq == len) {
                    ans = max(ans, len);
                }
            }
        }

        return ans;
    }
};