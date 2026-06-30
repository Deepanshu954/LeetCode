class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();

        int cnt = 0;
        for(int i = 0; i < n; i++) {
            int cntA = 0;
            int cntB = 0;
            int cntC = 0;

            for(int j = i; j < n; j++) {
                if(s.charAt(j) == 'a') cntA++;
                if(s.charAt(j) == 'b') cntB++;
                if(s.charAt(j) == 'c') cntC++;
                if(cntA != 0 && cntB != 0 && cntC != 0) cnt++;
            }
        }
        
        return cnt;
    }
}