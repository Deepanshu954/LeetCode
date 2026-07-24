class Solution {
    public int uniqueXorTriplets(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int num : nums) set.add(num);

        final int max = 2048;
        boolean[] pair = new boolean[max];
        boolean[] trip = new boolean[max];

        for(int first : set) {
            for(int sec : set) {
                pair[first ^ sec] = true;
            }
        }

        for(int i = 0; i < max; i++) {
            if(!pair[i]) continue;

            for(int third : set) trip[i ^ third] = true;
        }

        int val = 0;
        for(boolean reach : trip) {
            if(reach) val++;
        }

        return val;
    }
}