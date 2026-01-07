class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);

        int maxLen = 1;
        int len = 1;

        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i-1]) continue;
            else if(nums[i] == nums[i-1] + 1) len++;
            else len = 1;

            if(len > maxLen) maxLen = len;
        }
        return maxLen;
    }
}

// class Solution {
//     public int longestConsecutive(int[] nums) {
//         Set<Integer> set = new HashSet<>();
//         for(int num : nums) set.add(num);

//         int maxCount = 0;

//         for(int s : set){
//             int count = 1;

//             if(set.contains(s-1)) continue;
//             else {
//                 while(set.contains(s+1)){
//                     count++;
//                     s++;
//                 }
//             }

//             if(count > maxCount) maxCount = count;
//         }
//         return maxCount;
//     }
// }