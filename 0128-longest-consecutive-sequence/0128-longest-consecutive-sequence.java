class Solution {
    public int longestConsecutive(int[] nums) {
        int longest = 0;

        if(nums.length == 0) return 0;

        Set<Integer> s = new HashSet<>();

        for(int num : nums) s.add(num);

        for(int it : s) {
            if(!s.contains(it - 1)) {
                int cnt = 1;
                int x = it;

                while(s.contains(x + 1)) {
                    x = x + 1;
                    cnt++;
                }

                longest = Math.max(longest,cnt);
            }
        }

        return longest;
        
    }
}