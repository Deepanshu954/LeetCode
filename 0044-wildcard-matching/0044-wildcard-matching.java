class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        return rec(m-1, n-1, s, p);
    }

    private boolean rec(int i, int j, String s, String p) {
        if(i < 0 && j < 0) return true;
        if(j < 0) return false;

        if(i < 0) {
            for(int k = 0; k <= j; k++) {
                if(p.charAt(j) != '*') return false;
            } return true;
        }

        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
            return rec(i-1, j-1, s, p);
        } else if(p.charAt(j) == '*') {
            return  rec(i, j-1, s, p) || rec(i-1, j, s, p);
        } else return false;
    }
}