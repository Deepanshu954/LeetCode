class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);

        int count = 0;
        while (count < costs.length && coins >= costs[count]) {
            coins -= costs[count];
            count++;
        }

        return count;

    }
}