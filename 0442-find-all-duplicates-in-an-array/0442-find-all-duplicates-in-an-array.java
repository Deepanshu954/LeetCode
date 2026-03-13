class Solution {
    public List<Integer> findDuplicates(int[] nums) {
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
            if(nums[j] != j + 1) res.add(nums[j]);
        }

        return res;
    }
}


// class Solution {
//     public List<Integer> findDuplicates(int[] nums) {
//         Set<Integer> set = new HashSet<>();
//         Set<Integer> s = new HashSet<>();

//         for(int num : nums) {
//             if(!set.add(num)) s.add(num);
//         }

//         List<Integer> list = new ArrayList<>();

//         for(int i : s) list.add(i);
//         return list;
//     }
// }