class Solution {
    public boolean carPooling(int[][] trips, int cap) {
        List<int[]> events = new ArrayList<>();
        for(int[] trip : trips) {
            events.add(new int[]{trip[1],   trip[0]});
            events.add(new int[]{trip[2], - trip[0]});
        }

        events.sort((a,b) -> (a[0] == b[0]) ? a[1] - b[1] : a[0] - b[0] );

        int active = 0;
        for(int[] event : events) {
            active += event[1];
            if(active > cap) return false;
        }

        return true;
    }
}