class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        int longest = 1;
        int current = 1;

        Arrays.sort(nums);

        if(n == 0) return 0;

        for(int i = 0; i < nums.length ; i++){
            //if(nums[i] == nums[i-1]);
            if(nums[i] == nums[i-1]+1) longest++;
            else longest = 1;
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
