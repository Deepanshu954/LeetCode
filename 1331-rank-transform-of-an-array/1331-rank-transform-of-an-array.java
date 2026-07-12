class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;

        int[] nums = arr.clone();
        Arrays.sort(nums);

        HashMap<Integer, Integer> map = new HashMap<>();

        int cnt = 1;
        map.put(nums[0], cnt++);
        for(int i = 1; i < n; i++) {
            if(nums[i-1] == nums[i]) continue;

            map.put(nums[i], cnt++);
        }

        for(int i = 0; i < n; i++) {
            int val = map.get(arr[i]);
            nums[i] = val;
        }



        return nums;
    }
}