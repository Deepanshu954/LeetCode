class Solution {
    public int[] findErrorNums(int[] nums) {

        boolean[] arr = new boolean[nums.length + 1];
        int[] res = new int[2];

        for (int num : nums) {
            if (arr[num] == true)
                res[0] = num;
            else
                arr[num] = true;
        }

        for (int i = 1; i <= nums.length; i++) {
            if (arr[i] != true) {
                res[1] = i;
                return res;
            }
        }

        return res;
    }
}