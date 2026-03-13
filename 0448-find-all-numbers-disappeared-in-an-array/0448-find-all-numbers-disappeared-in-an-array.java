class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();

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
            if(nums[j] != j + 1) res.add(j+1);
        }

        return res;
    }
}


// class Solution {
//   public List<Integer> findDisappearedNumbers(int[] nums) {
//     List<Integer> ans = new ArrayList<>();

//     for (final int num : nums) {
//       final int index = Math.abs(num) - 1;
//       nums[index] = -Math.abs(nums[index]);
//     }

//     for (int i = 0; i < nums.length; ++i)
//       if (nums[i] > 0)
//         ans.add(i + 1);

//     return ans;
//   }
// }