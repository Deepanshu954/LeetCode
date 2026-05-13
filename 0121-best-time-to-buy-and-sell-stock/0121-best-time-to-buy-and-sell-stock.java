class Solution {
    public int maxProfit(int[] prices) {
        int pro = 0;
        int max = 0;
        int min = prices[0];
    
        for(int num : prices) {
            if(min > num) {
                min = num;
                pro = 0;
            }

            pro = num - min;
            max = Math.max(max, pro);
        }

        return max;
    }
}