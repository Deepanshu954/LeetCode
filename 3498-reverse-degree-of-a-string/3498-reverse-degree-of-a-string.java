class Solution {
    public int reverseDegree(String s) {
        int n = s.length();
        int res = 0;

        for(int i = 0; i < n; i++) {
            int ch = (s.charAt(i) - 'a') + 1; 

            res += ((i+1) * (27 - ch)) ;
        }

        return res;
    }
}