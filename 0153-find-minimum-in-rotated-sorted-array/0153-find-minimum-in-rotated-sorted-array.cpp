class Solution {
public:
    int findMin(vector<int>& nums)
    {
        int low = 0, high = nums.size() - 1;

        while (low < high)
        {
            int mid = low + (high - low) / 2;

            if (nums[mid] > nums[high])
            {
                // Minimum must be in the right half
                low = mid + 1;
            }
            else
            {
                // Minimum is in the left half including mid
                high = mid;
            }
        }

        return nums[low];
    }
};