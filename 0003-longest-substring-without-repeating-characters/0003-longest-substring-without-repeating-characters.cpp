class Solution {
public:
    int lengthOfLongestSubstring(string s) 
    {
        int n = s.length();
        unordered_map<char, int> mp;
        int maxLen = 0, left = 0;

        for(int right = 0; right < n; right++)
        {
            char ch = s[right];
            mp[ch]++;
            
            while(mp[ch] > 1)
            {
                mp[s[left]]--;
                left++;
            }

            maxLen = max(maxLen, right - left + 1);
        }

        return maxLen;
    }
};