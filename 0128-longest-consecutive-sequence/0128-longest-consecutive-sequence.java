class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        int longest = 0;

        HashSet<Integer> set = new HashSet<>();
        for(int num : nums) set.add(num);
        
        for(int s : set){
            if(!set.contains(s - 1)){
                int cnt = 1;
                int x = s;

                while(set.contains(x+1)){
                    cnt++;
                    x++;
                }
                longest = Math.max(longest, cnt);
            }
            
        }

        return longest;
    }
}