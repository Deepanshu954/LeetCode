class Solution {
    public int findDuplicate(int[] nums) {
        int idx = 0;

        while(idx < nums.length) {
            int correctIdx = nums[idx] - 1;

            if(nums[idx] != idx + 1) {
                if(nums[idx] != nums[correctIdx]) {
                    int temp = nums[idx];
                    nums[idx] = nums[correctIdx];
                    nums[correctIdx] = temp;
                } else {
                    return nums[idx];
                }

            } else idx++;
        }

        return -1;
    }
}


// // This this as a linked list.
// // Pointer is going to that particular index
// // If number is same it get stuck

// class Solution {
//     public int findDuplicate(int[] nums) {

//         int slow = nums[0];
//         int fast = nums[0];

//         // Phase 1: detect cycle
//         do {
//             slow = nums[slow];
//             fast = nums[nums[fast]];
//         } while (slow != fast);

//         // Phase 2: find entry point
//         slow = nums[0];
//         while (slow != fast) {
//             slow = nums[slow];
//             fast = nums[fast];
//         }

//         return slow;
//     }
// }