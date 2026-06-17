// 1, 1, 1

// steps
// 1. store sum of all elemets till that index
// like idx = 5, will contain sum of all previous elemts
 // 5
 // k == 3
 // 2

 // get value form previous index


class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);

        int cnt = 0;
        int sum = 0;

        for(int i = 0; i < n; i++) {
            sum += nums[i];

            if(map.containsKey(sum - k)) {
                cnt += map.get(sum - k);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        // for(int i = 0; i < n; i++) {
        //     int sum = 0;
        //     for(int j = i; j < n; j++) {
        //         sum += nums[j];

        //         if(sum == k) cnt++;
        //     }
        // }

        return cnt;
    }
}

// 


