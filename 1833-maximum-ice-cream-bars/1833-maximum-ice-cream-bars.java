class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int maxCost = 0;
        for (int cost : costs) {
            if (cost > maxCost) {
                maxCost = cost;
            }
        }

        int[] frequency = new int[maxCost + 1];
        for (int cost : costs) {
            frequency[cost]++;
        }

        int count = 0;

        for (int price = 1; price <= maxCost; price++) {
            if (frequency[price] == 0) continue;
            if (coins < price) break;
            
            int canBuy = Math.min(frequency[price], coins / price);

            count += canBuy;
            coins -= canBuy * price;

            if (coins == 0) break;
        }

        return count;
    }
}
