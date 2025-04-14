class Solution {
public:
    bool isAnagram(string s, string t) {
        if (s.length() != t.length()) return false;

        map<char, int> map1, map2;

        // Count characters in both strings
        for (int i = 0; i < s.length(); i++) {
            map1[s[i]]++;
            map2[t[i]]++;
        }

        // Compare frequency of each character
        for (char c : s) {
            if (map1[c] != map2[c]) return false;
        }

        return true;
    }
};