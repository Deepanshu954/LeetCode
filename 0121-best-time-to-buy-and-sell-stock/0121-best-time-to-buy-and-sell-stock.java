class Solution {
    public int maxProfit(int[] prices) {
        int pro = 0;
        int max = 0;
        int min = prices[0];

        for(int num : prices) {
            min = Math.min(min, num);
            max = Math.max(max, num - min);
        }

        return max;
    }
}