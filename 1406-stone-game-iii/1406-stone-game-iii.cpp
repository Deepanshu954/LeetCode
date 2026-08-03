#include <vector>
#include <string>
#include <algorithm>
#include <climits>

class Solution {
public:
    std::string stoneGameIII(std::vector<int>& stoneValue) {
        int n = stoneValue.size();
        
        
        int dp1 = 0, dp2 = 0, dp3 = 0; 

        
        for (int i = n - 1; i >= 0; --i) {
            int current_take_sum = 0;
            int max_diff = INT_MIN;

           
            for (int k = 1; k <= 3 && i + k <= n; ++k) {
                current_take_sum += stoneValue[i + k - 1];

                int opponent_diff = (k == 1) ? dp1 : (k == 2) ? dp2 : dp3;
                
                max_diff = std::max(max_diff, current_take_sum - opponent_diff);
            }

            
            dp3 = dp2;
            dp2 = dp1;
            dp1 = max_diff;
        }

        
        if (dp1 > 0) return "Alice";
        if (dp1 < 0) return "Bob";
        return "Tie";
    }
};