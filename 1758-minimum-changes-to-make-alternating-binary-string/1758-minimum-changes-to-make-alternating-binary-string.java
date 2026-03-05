class Solution {
    public int minOperations(String s) {
        int n = s.length();
        if(n == 0) return 0;

        int cnt0 = 0;
        int cnt1 = 0;

        int extra = n % 2;

        for(int i = 0; i < n - extra; i = i + 2) {
            if(s.charAt(i) != '0') cnt0++;
            if(s.charAt(i+1) != '1') cnt1++;
        }

        if(extra == 1) {
            if(s.charAt(n - 1) != '0') cnt0++;
        }

        int ans = cnt0 + cnt1;

        //ans = Math.min(ans, n - ans);

        return ans < (n - ans) ? ans : n - ans;
    }
}