class Solution {
    public int longestConsecutive(int[] nums) {
        int maxCount = 0;

        HashSet<Integer> set = new HashSet<>();
        for(int num : nums) set.add(num);

        for(int s : set){
            if(set.contains(s - 1)) continue;

            int count = 0;
            while(set.contains(s++)) count++;

            maxCount = Math.max(count, maxCount);
        }
        return maxCount;
        
    }
}
