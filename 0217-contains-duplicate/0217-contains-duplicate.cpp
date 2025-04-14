class Solution {
public:
    bool containsDuplicate(vector<int>& nums) 
    {
        unordered_map<int,int> map;

        for(int i = 0; i < nums.size(); i++)
        {
            map[nums[i]]++;
        }

        for(auto & i : map)
        {
            if(i.second > 1) return true;
        }

        // for(int i = 0; i < nums.size(); i++)
        // {
        //     for(int j = i+1; j < nums.size(); j++)
        //     {
        //         if(nums[i] == nums[j]) return true;
        //     }
        // }

        return false;
    }
};