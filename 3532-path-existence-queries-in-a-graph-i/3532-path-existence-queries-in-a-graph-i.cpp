const int N=100000;
int root[N], Rank[N];
class UnionFind {
public:
    UnionFind(int n){
        iota(root, root+n, 0);
        fill(Rank, Rank+n, 1);    
    }
    
    int Find(int x) {
        return (x==root[x]) ? x : root[x] = Find(root[x]);
    }

    bool Union(int x, int y) {//Union by rank
        int rX = Find(x), rY = Find(y);
        if (rX == rY)
            return 0;
        if (Rank[rX] > Rank[rY])
            swap(rX, rY);
        root[rX] = rY;
        if (Rank[rX] == Rank[rY])
            Rank[rY]++;
        return 1;
    }
    bool isConnected(int x, int y){
        return Find(x)==Find(y);
    }
};
class Solution {
public:
    static vector<bool> pathExistenceQueries(int n, vector<int>& nums, int maxDiff, vector<vector<int>>& queries) {
        const int qz=queries.size();
        vector<bool> ans(qz);
        UnionFind G(n);
        int prev=nums[0];
        for(int i=1; i<n; i++){
            const int curr=nums[i];
            if (prev+maxDiff>=curr)
                G.Union(i-1, i);
            prev=curr;
        }
        for (int i=0; i<qz; i++){
            const int x=queries[i][0], y=queries[i][1];
            ans[i]=G.isConnected(x, y);
        }
        return ans;
    }
};


auto init = []() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    return 'c';
}();