class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);

        int cnt = 0;
        while (cnt < costs.length && coins >= costs[cnt]) {
            coins -= costs[cnt++];
            //cnt++;
        }

        return cnt++;

    }
}