class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        Arrays.sort(houses);

        int n = houses.length;
        int m = heaters.length;

        int i = 0;
        int j = 0;

        int res = 0;

        while(i < n && j < m) {
            int dist1 = Math.abs(houses[i] - heaters[j]);
            int dist2 = (int)1e9;

            if(j+1 < m) {
                dist2 = Math.abs( heaters[j+1] - houses[i]);
            }

            if(dist1 < dist2) {
                res = Math.max(res, dist1);
                i++;
            } else j++;
        }

        return res;
        
    }
}