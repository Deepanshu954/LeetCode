class Solution {
public:
    int subarraySum(vector<int>& nums, int k) 
    {
        unordered_map<int, int> prefixSumFreq;
        prefixSumFreq[0] = 1;

        int sum = 0, count = 0;

        for(int num : nums)
        {
            sum += num;

            if(prefixSumFreq.find(sum - k) != prefixSumFreq.end())
            {
                count += prefixSumFreq[sum - k];
            }

            prefixSumFreq[sum]++;
        }

        return count;
    }
};