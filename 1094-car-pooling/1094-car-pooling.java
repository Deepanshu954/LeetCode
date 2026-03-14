class Solution {
    public boolean carPooling(int[][] trips, int capacity) {

        int[] diff = new int[1001];

        for(int[] trip : trips) {
            int people = trip[0];
            int from = trip[1];
            int to = trip[2];

            diff[from] += people;
            diff[to] -= people;
        }

        int passCount = 0;

        for(int pass : diff) {
            passCount += pass;

            if(passCount > capacity) return false;
        }

        return true;
    }
}