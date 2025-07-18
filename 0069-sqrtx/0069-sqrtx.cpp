class Solution {
public:
    int mySqrt(int x)
    {
        long long low = 1;
        long long high = x/2;
        long long ans,mid,val;

        while(low <= high)
        {
            mid = low + (high-low)/2;

            val = mid * mid;
            if(val == x) return mid;
            else if(val < x)
            {
                ans = mid;
                low = mid + 1;
            }
            else
            {
                high = mid-1;
            }
        }


        return ans;
    }
};