class Solution {
    public int countDays(int days, int[][] meet) {
        int n = meet.length;

        int[] start = new int[n];
        int[] end = new int[n];

        for(int i = 0; i < n; i++) {
            start[i] = meet[i][0];
            end[i] = meet[i][1];
        }

        // Arrays.sort(meet, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        Arrays.sort(start);
        Arrays.sort(end);

        int cnt = 0;
        int ans = 0;

        int i = 0;
        int j = 0;

        while(i < n && j < n) {
            if(start[i] < end[j]) {
                cnt++;
                i++;
            } else {
                cnt--;
                j++;
            }

            if(cnt == 0) ans++;
        }

        return ans + (days - end[n-1]) + start[0] - 1;
    }
}