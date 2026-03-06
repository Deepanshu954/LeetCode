class Solution {
    public boolean checkOnesSegment(String s) {
        //if(s.length() == 1 && s.charAt(0) == '1') return true;
        int cnt = 0;
        int change = 0;

        for(char ch : s.toCharArray()) {
            if(ch == '1') {
                cnt++;
                change++;
                if(cnt > 1) return true;
            } else cnt = 0;
        }

        return change == 1 ? true : false;
    }
}