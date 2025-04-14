class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        unordered_map <string,vector<string>> res;
        for(int i=0;i<strs.size();i++){
            string sortedS = strs[i];
            sort(sortedS.begin(),sortedS.end());
            res[sortedS].push_back(strs[i]);
        }

        vector<vector<string>> ans;
        for(auto pair:res){
            ans.push_back(pair.second);
        }
        return ans;
    }
};
