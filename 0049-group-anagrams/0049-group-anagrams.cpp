class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        unordered_map<string, vector<string>> hash;

        for(string s : strs) {
            string key = s;
            sort(key.begin(), key.end()); // same anagrams will have same sorted string
            hash[key].push_back(s);
        }

        vector<vector<string>> result;
        for(auto& it : hash) {
            result.push_back(it.second);
        }

        return result;
    }
};