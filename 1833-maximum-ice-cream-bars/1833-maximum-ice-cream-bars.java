import java.util.Map;
import java.util.TreeMap;

class Solution {
    public int maxIceCream(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            if (nums[i] <= k) map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        int cnt = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int price = entry.getKey();
            int ava = entry.getValue();

            int canAfford = k / price;
            int bought = Math.min(ava, canAfford);

            cnt += bought;
            k -= (price * bought);

            if (k < price) break;
        }

        return cnt;
    }
}


// class Solution {
//     public int maxIceCream(int[] costs, int coins) {
//         Arrays.sort(costs);

//         int cnt = 0;
//         while (cnt < costs.length && coins >= costs[cnt]) {
//             coins -= costs[cnt++];
//         }

//         return cnt++;
//     }
// }