class Solution {
    public int climbStairs(int n, int[] costs) {
        int a = 0;
        int b = 0;
        int c = 0;

        for(int cost : costs) {
            int curr = cost + Math.min(a+1, Math.min(b+4, c + 9));

            c = b;
            b = a;
            a = curr;
        }

        return a;
    }
}