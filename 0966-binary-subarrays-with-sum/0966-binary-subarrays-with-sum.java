class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);

        int cnt = 0, prefixSum = 0;

        for(int num : nums){
            prefixSum += num;

            if(map.containsKey(prefixSum - goal)) cnt += map.get(prefixSum - goal);

            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return cnt;
    }
}