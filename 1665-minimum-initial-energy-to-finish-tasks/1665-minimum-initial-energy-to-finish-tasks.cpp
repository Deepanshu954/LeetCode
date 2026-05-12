class Solution {
public:
    int minimumEffort(vector<vector<int>>& tasks) {
        vector<pair<int,int>> t;
        for(auto i: tasks){
            t.push_back(make_pair(i[0] - i[1], -1*i[1]));
        }
        sort(t.begin(), t.end());
        int a = t[0].first - t[0].second;
        int r = -1*t[0].second;
        for(int i = 1; i < tasks.size(); i++){
            r = max(r, a + -1*t[i].second);
            a += t[i].first - t[i].second;
        }
        return r;
    }
};