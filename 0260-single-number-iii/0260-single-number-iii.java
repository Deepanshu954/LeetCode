class Solution {
    public int[] singleNumber(int[] nums) {
        Arrays.sort(nums);

        int[] arr = new int[2];
        int index = 0;
        int n = nums.length;

        // Check first element
        if (nums[0] != nums[1]) {
            arr[index++] = nums[0];
        }

        // Check middle elements
        for (int i = 1; i < n - 1; i++) {
            if (nums[i] != nums[i - 1] && nums[i] != nums[i + 1]) {
                arr[index++] = nums[i];
            }
        }

        // Check last element
        if (nums[n - 1] != nums[n - 2]) {
            arr[index++] = nums[n - 1];
        }

        return arr;
    }
}