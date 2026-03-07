class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        int count = 0;
        map.put(0,1);

        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(map.containsKey(sum - nums[i])) {
                count += map.get(sum - nums[i]);
            }

            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        return count;
    }
}