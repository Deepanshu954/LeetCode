class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a,b) -> Integer.compare(a[1], b[1]));

        int ans = 0;
        int curr = points[0][1];

        for(int i = 1; i < points.length; i++) {
            if(points[i][0] <= curr) ans++;
            else curr = points[i][1];
        }

        return points.length - ans;
    }
}