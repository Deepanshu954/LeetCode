class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums) set.add(num);

        int maxCount = 0;

        for(int s : set){
            int count = 1;

            if(set.contains(s-1)) continue;
            else {
                while(set.contains(s+1)){
                    count++;
                    s++;
                }
            }

            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
}