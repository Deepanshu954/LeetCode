class Solution {
    public int[] findErrorNums(int[] nums) {
        int i = 0;
        while(i < nums.length) {
            int correct = nums[i] - 1;

            if(nums[i] != nums[correct]) {
                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;
            } else i++;
        }

        for(int j = 0; j < nums.length; j++) {
            if(nums[j] != j+1) {
                return new int[] {nums[j], j+1};
            }
        }
        

        return new int[]{-1,-1};
    }
}


// class Solution {
//     public int[] findErrorNums(int[] nums) {

//         boolean[] arr = new boolean[nums.length + 1];
//         int[] res = new int[2];

//         for (int num : nums) {
//             if (arr[num] == true)
//                 res[0] = num;
//             else
//                 arr[num] = true;
//         }

//         for (int i = 1; i <= nums.length; i++) {
//             if (arr[i] != true) {
//                 res[1] = i;
//                 return res;
//             }
//         }

//         return res;
//     }
// }