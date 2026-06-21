class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);

        if(costs[0] > coins) return 0;

        int idx = 0;
        while(coins > 0 && idx < costs.length) {
            coins -= costs[idx++];
        }

        return idx;
    }
}