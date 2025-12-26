class Solution {
    public int longestConsecutive(int[] nums) {
        int maxCount = 0;

        HashSet<Integer> set = new HashSet<>();
        for(int num : nums) set.add(num);

        for(int num : nums){
            if(set.contains(num - 1)) continue;

            int count = 0;
            while(set.contains(num++)) count++;

            maxCount = Math.max(count, maxCount);
        }
        return maxCount;
        
    }
}