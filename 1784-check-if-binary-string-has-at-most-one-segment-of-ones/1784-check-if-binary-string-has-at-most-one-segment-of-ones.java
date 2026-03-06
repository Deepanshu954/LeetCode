class Solution {
    public boolean checkOnesSegment(String s) {
        int cnt = 0;

        for(char ch : s.toCharArray()) {
            if(ch == '1') {
                cnt++;
                if(cnt > 1) return true;
            } else cnt = 0;
        }

        return false;
    }
}