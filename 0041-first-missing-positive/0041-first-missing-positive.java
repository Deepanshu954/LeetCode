class Solution {
    public int firstMissingPositive(int[] nums) {
        int i = 0;
        int n = nums.length;

        for(int j = 0; j < n;j++) {
            if(nums[j] < 1) nums[j] = n + 1;
        }

        while(i < nums.length) {
            int correct = nums[i] - 1;

            if(nums[i] < nums.length && nums[i] != nums[correct]) {
                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;
            } else i++;
        }

        if(nums[0] != 1) return 1;
        if(nums[1] != 2) return 2;

        for(int j = 0; j < nums.length; j++) {
            if(nums[j] != j+1) return j + 1;
        }

        return nums.length;
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