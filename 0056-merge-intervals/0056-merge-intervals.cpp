class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals)
    {
        int n = intervals.size();
        vector<vector<int>> arr;

        sort(intervals.begin(), intervals.end());

        arr.push_back(intervals[0]);

        for(int i = 1; i < n; i++)
        {

            vector<int>& last = arr.back();

            if(intervals[i][0] <= last[1])
            {
                last[1] = max(last[1], intervals[i][1]);
            }
            else
            {
                arr.push_back(intervals[i]);
            }
        }

        return arr;
    }
};