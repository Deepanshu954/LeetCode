class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int sum = 0;
        int maxLen = 0;

        for(int i = 0; i < nums.length; i++) {
            sum += nums[i] == 0 ? -1 : 1;

            if(map.containsKey(sum)) maxLen = Math.max(maxLen, i - map.get(sum));
            else map.put(sum, i);
        }

        return maxLen;
    }
}


// class Solution {
//     public int findMaxLength(int[] nums) {
//         int max = 0;

//         for(int i = 0; i < nums.length; i++) {
//             int cnt0 = 0;
//             int cnt1 = 0;
//             for(int j = i; j < nums.length; j++) {
//                 if(nums[j] == 0) cnt0++;
//                 else cnt1++;

//                 if(cnt0 == cnt1) {
//                     max = Math.max(cnt0 * 2, max);
//                 }
//             }
//         }

//         return max;
//     }
// }