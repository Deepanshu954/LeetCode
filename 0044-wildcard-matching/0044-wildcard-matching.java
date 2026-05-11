class Solution {
    public boolean isMatch(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        return rec(m-1, n-1, s1, s2);
    }

    private boolean rec(int i, int j, String s1, String s2) {
        if(i < 0) return true;
        if(j < 0) return false;

        char ch1 = s1.charAt(i);
        char ch2 = s2.charAt(j);

        if(ch1 == ch2 || ch2 == '?') return rec(i-1, j-1, s1, s2);

        if(ch2 == '*') return rec(i-1, j-1, s1, s2) || rec(i-1, j, s1, s2);

        return false;
    }
}