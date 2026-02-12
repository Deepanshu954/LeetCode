class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k-1);
    }

    private int atMostK(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();

        int cnt = 0;
        int left = 0;
        for(int right = 0; right < nums.length; right++) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);


            while(map.size() > k) {
                map.put(nums[left], map.get(nums[left]) - 1);

                if(map.get(nums[left]) == 0) map.remove(nums[left]);
                left++;
            }
            
            cnt += right - left + 1;
        }

        return cnt;
    }

    private int atMost(int[] nums, int k) {

        int[] freq = new int[nums.length + 1];

        int left = 0;
        int count = 0;
        int unique = 0;

        for(int right = 0; right < nums.length; right++) {

            // Unique Case
            if(freq[nums[right]] == 0) unique++;

            // Expand Window
            freq[nums[right]]++;

            // Srink Window
            while(unique > k) {
                
                freq[nums[left]]--;

                if(freq[nums[left]] == 0) unique--;

                left++;
            }

            count += right - left + 1;
        }

        return count;
    }
}