class Solution {
public:
    void nextPermutation(vector<int>& nums) 
    {
        int n = nums.size();
        if(n <= 1) return;

        int i = n - 2;

        // Step 1: Find the first decreasing index from the right
        while(i >= 0 && nums[i] >= nums[i + 1])
        {
            i--;
        }

        // Step 2: If we found such an index
        if(i >= 0)
        {
            int j = n - 1;
            while(nums[j] <= nums[i])
            {
                j--;
            }
            swap(nums[i], nums[j]);
        }

        // Step 3: Reverse the suffix
        reverse(nums.begin() + i + 1, nums.end());
    }
};