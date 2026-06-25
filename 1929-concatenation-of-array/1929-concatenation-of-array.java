class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int size = 2 * n;

        int[] arr = new int[size];

        for(int i = 0; i < n; i++) {
            arr[i] = nums[i];
            arr[n+i] = nums[i];
        }

        return arr;
    }
}