class Solution {
public:
    int maxVal(vector<int> &nums)
    {
        int maxi = INT_MIN;
        for(int num : nums)
        {
            maxi = max(maxi, num);
        }

        return maxi;
    }

    long long valCalculate(vector<int> &nums, int hourly)
    {
        long long totalH = 0;
        for(int num : nums)
        {
            totalH += (num + hourly - 1)/hourly;
        }

        return totalH;
    }

    int minEatingSpeed(vector<int>& piles, int h)
    {
        int low = 1;
        int high = maxVal(piles);

        while(low <= high)
        {
            int mid = low + (high-low)/2;

            long long totalH = valCalculate(piles,mid);

            if(totalH <= h)
            {
                high = mid-1;
            }
            else
            {
                low = mid+1;
            }
        }

        return low;
    }
};