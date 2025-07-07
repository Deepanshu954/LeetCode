class Solution {
public:
    int majorityElement(vector<int>& nums) 
    {
        int n = nums.size();
        int val{0};
        int count{0};
        int verify{0};

        for(int i = 0; i < n; i++)
        {
            if(nums[i] == val) count++;
            else if(count == 0)
            {
                val = nums[i];
                count++;
            }
            else
            {
                count--;
            }
        }

        // There is no need to verify in this one 
        for(int i = 0; i < n; i++)
        {
            if(nums[i] == val)
            {
                verify++;
            }
        }

        if(verify > (n/2))
        {
            return val;
        }
        else
        {
            return 0;
        }
        
/*
        unordered_map<int,int> mp;

        for(int i = 0; i < n;i++)
        {
            mp[nums[i]]++;
        }

        for(auto it : mp)
        {
            if(it.second > max)
            {
                return it.first ;
            }
        }
*/

    }
};