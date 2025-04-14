class Solution {
public:
    bool isAnagram(string s, string t) {
        if (s.length() != t.length()) return false;

        map<char, int> freq;

        for (int i = 0; i < s.length(); i++) {
            freq[s[i]]++;
            freq[t[i]]--;
        }

        for (auto& entry : freq) {
            if (entry.second != 0) return false;
        }

        return true;
    }
};