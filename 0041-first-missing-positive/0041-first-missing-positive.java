class Solution {
    public int firstMissingPositive(int[] nums) {
        int i = 0;

        while(i < nums.length) {
            int correct = nums[i] - 1;

            if(nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[correct]) {
                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;
            } else i++;
        }

        for(int j = 0; j < nums.length; j++) {
            if(nums[j] != j+1) return j + 1;
        }

        return nums.length + 1;
    }
}

// class Solution {
//     public int firstMissingPositive(int[] nums) {
//         Set<Integer> set = new HashSet<>();
        
//         for(int num : nums) set.add(num);

//         for(int i = 1; i <= nums.length; i++)
//         {
//             if(!set.contains(i)) return i;
//         }
        
//         return nums.length + 1;
//     }
// }