class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num, map.getOrDefault(num,0) + 1);
        }

        int[] arr = new int[k];

        for(int i = 0; i < k; i++) {
            int max = -1;
            int maxEle = -1;

            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if(entry.getValue() > max) {
                    max = entry.getValue();
                    maxEle = entry.getKey();
                }
            }

            arr[i] = maxEle;
            map.put(maxEle, 0);
        }

        return arr;
    }
}