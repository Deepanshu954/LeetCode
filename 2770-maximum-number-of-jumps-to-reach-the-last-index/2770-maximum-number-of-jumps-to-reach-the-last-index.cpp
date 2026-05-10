class Solution {
public:
    int dp[1001][1001]; // Memoization array to store calculated results
    
    int helper(int ind, int n, vector<int>& nums, int t, int prev) {
        if (ind == n) {
            if (prev == n-1)
                return 0;
            return INT_MIN;
        }
        
        if (dp[ind][prev] != -1)
            return dp[ind][prev];
        
        int ans = INT_MIN; // Initializing answer variable to negative infinity
        int x = nums[ind] - nums[prev]; // Calculating difference between current and previous element
        
        if (x >= -1*t && x <= t) // Checking if difference is within the allowed range
            ans = max(ans, 1 + helper(ind+1, n, nums, t, ind)); // Recursive call with current index as new previous index
        
        ans = max(ans, helper(ind+1, n, nums, t, prev)); // Recursive call without making a jump
        
        return dp[ind][prev] = ans; // Storing calculated result in dp array and returning the answer
    }
    
    int maximumJumps(vector<int>& nums, int target) {
        int n = nums.size();
        memset(dp, -1, sizeof(dp)); // Initializing dp array with -1
        
        int ans = helper(0, n, nums, target, 0); // Calling helper function to get maximum jumps
        
        return ans > 0 ? ans - 1 : -1; // Returning the result, subtracting 1 if valid sequence found, otherwise -1
    }
};