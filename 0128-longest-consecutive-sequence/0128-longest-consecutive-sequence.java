class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        int longest = 1;
        int curr = 1;

        Arrays.sort(nums);

        if(n == 0) return 0;

        for(int i = 1; i < nums.length ; i++){
            if(nums[i] == nums[i-1]) continue;
            if(nums[i] == nums[i-1]+1) curr++;
            else curr = 1;

            longest = Math.max(curr, longest);
        }
        return longest;
    }
}

// class Solution {
//     public int longestConsecutive(int[] nums) {
//         int maxCount = 0;

//         HashSet<Integer> set = new HashSet<>();
//         for(int num : nums) set.add(num);

//         for(int s : set){
//             if(set.contains(s - 1)) continue;

//             int count = 0;
//             while(set.contains(s++)) count++;

//             maxCount = Math.max(count, maxCount);
//         }
//         return maxCount;
        
//     }
// }
