class Solution {
    public int minMoves(int[] nums) {
        int min = (int)1e9;

        for(int num : nums) {
            if(num < min) min = num;
        }

        long moves = 0;
        for(int x : nums) {
            moves += (long) x - min;
        }

        return (int) moves;
    }
}