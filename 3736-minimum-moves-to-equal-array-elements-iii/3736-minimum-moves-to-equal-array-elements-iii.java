class Solution {
    public int minMoves(int[] nums) {
        int max = 0;
        int sum = 0;

        for(int num : nums) {
            sum += num;
            if(max < num) max = num;
        }

        return nums.length * max - sum;
    }
}