class Solution {
    public void sortColors(int[] nums) {
        int cnt0 = 0;
        int cnt1 = 0;
        int cnt2 = 0;

        for(int num : nums)
        {
            if(num == 0) cnt0++;
            else if(num == 1) cnt1++;
            else cnt2++;
        }

        int index = 0;

        while(cnt0 > 0) {nums[index++] = 0; cnt0--;}
        while(cnt1 > 0) {nums[index++] = 1; cnt1--;}
        while(cnt2 > 0) {nums[index++] = 2; cnt2--;}
        
        return;
    }
}



// class Solution {
//     public void sortColors(int[] nums) {
//         int low = 0, mid = 0, high = nums.length - 1;

//         while (mid <= high) {
//             if (nums[mid] == 0) {
//                 swap(nums, low, mid);
//                 low++;
//                 mid++;
//             } else if (nums[mid] == 1) {
//                 mid++;
//             } else {
//                 swap(nums, mid, high);
//                 high--;
//             }
//         }
//     }

//     private void swap(int[] nums, int i, int j) {
//         int temp = nums[i];
//         nums[i] = nums[j];
//         nums[j] = temp;
//     }
// }