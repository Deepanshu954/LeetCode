class Solution {
public:
    int maxSubArray(vector<int>& nums) 
    {
        int n = nums.size();
        int maxSum = nums[0];
        int sum = nums[0];

        for(int i = 1; i < n; i++)
        {
            sum = max(nums[i], sum + nums[i]);
            maxSum = max(sum, maxSum);
        }

/*
     
        for(int i = 0; i < n; i++)
        {
            int sum = 0;
            for(int j = i; j < n; j++)
            {
                sum += nums[j];
                if(maxSum < sum)
                {
                    maxSum = sum;
                }
            }
        }
*/
        return maxSum;
    }
};