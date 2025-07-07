class Solution {
public:
    int maxProfit(vector<int>& prices) 
    {
        int minPrice = INT_MAX;
        int maxProfit = 0;

        for(int price : prices)
        {
            if(price < minPrice)
            {
                minPrice = price;  // Update min buying price
            }
            else
            {
                maxProfit = max(maxProfit, price - minPrice);  // Update max profit
            }
        }
        return maxProfit;
    }
};