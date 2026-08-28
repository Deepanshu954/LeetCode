class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> events = new ArrayList<>();
        for(int[] interval : intervals) {
            events.add(new int[] {interval[0], 1});
            events.add(new int[] {interval[1], -1});
        }

        events.sort((a, b) ->
            (a[0] == b[0]) ? b[1] - a[1] : a[0] - b[0]
        );

        ArrayList<int[]> list = new ArrayList<>();

        int s = -1;
        int active = 0;

        for(int[] event : events) {
            active += event[1];

            if(active > 0 && s == -1) s = event[0];

            if(active == 0) {
                list.add(new int[]{s, event[0]});
                s = -1;
            }
        }

        return list.toArray(new int[list.size()][]);
    }
}