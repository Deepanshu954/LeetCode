class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        unordered_map<int, int> m;
        for(int val:nums)
            m[val]++;
        
        priority_queue<pair<int, int>> pq;
        for(auto pair: m)
            pq.push({pair.second, pair.first});
        
        vector<int> ans;
        int c = 0;
        while(!pq.empty()){
            if(++c>k) break;
            auto val = pq.top();
            pq.pop();
            ans.push_back(val.second);
        }
        return ans;
    }
};