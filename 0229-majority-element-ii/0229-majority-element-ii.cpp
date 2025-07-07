class Solution {
public:
    vector<int> majorityElement(vector<int>& nums)
    {
        int n = nums.size();
        int count1{0},count2{0},candidate1{0},candidate2{1};
        vector<int> arr;

        for(int i = 0; i < n; i++)
        {
            if(nums[i] == candidate1) count1++;
            else if(nums[i] == candidate2) count2++;
            else if(count1 == 0)
            {
                candidate1 = nums[i];
                count1++;
            }
            else if(count2 == 0)
            {
                candidate2 = nums[i];
                count2++;
            }
            else
            {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;

        for(int i = 0; i < n; i++)
        {
            if(nums[i] == candidate1) count1++;
            else if(nums[i] == candidate2) count2++;
        }

        if(count1 > n/3) arr.push_back(candidate1);
        if(count2 > n/3) arr.push_back(candidate2);

        return arr;
    }
};