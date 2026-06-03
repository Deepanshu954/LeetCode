class Solution {
    public int[] twoSum(int[] nums, int k) {
        int n = nums.length;

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            int diff = k - nums[i];

            if(map.containsKey(diff)) {
                return new int[]{map.get(diff), i};
            }

            map.put(nums[i], i);
        }

        return new int[]{-1, -1};
    }
}