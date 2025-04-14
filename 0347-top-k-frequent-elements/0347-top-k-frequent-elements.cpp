class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k)
    {
        unordered_map<int,int> map;

        // Step 1: Count frequency
        for(int i = 0; i < nums.size(); i++)
        {
            map[nums[i]]++;
        }

        // Step 2: Min heap to store top k elements
        priority_queue<pair<int,int>, vector<pair<int,int>>, greater<pair<int,int>>> pq;

        for(auto it : map)
        {
            pq.push({it.second, it.first}); // (frequency, number)

            if(pq.size() > k)
            {
                pq.pop();
            }
        }

        // Step 3: Extract top k elements
        vector<int> ans;
        while(!pq.empty())
        {
            ans.push_back(pq.top().second);
            pq.pop();
        }

        return ans;
    }
};