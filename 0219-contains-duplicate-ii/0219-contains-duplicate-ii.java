// class Solution {
//     public boolean containsNearbyDuplicate(int[] nums, int k) {
//         HashSet<Integer> set = new HashSet<>();

//         for(int i = 0; i < k; i++) set.add(nums[i]);
//         for(int i = k; i < nums.length; i++){
//             if(!set.add(nums[i])) return true;
//             set.remove(nums[i-k]);
//         }
//         return false;
//     }
// }


class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < nums.length; i++){
            if(!set.add(nums[i])) return true;
            if(i - k >= 0) set.remove(nums[i-k]);
        }
        return false;
    }
}