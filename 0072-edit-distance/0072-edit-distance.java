class Solution {
    public int minDistance(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        return rec(m-1, n-1, s1, s2);
    }

    private int rec(int i, int j, String s1, String s2) {
        if(i < 0) return j+1;
        if(j < 0) return i+1;

        if(s1.charAt(i) == s2.charAt(j)) {
            return rec(i-1, j-1, s1, s2);
        }

        int ins = rec(i-1, j, s1, s2);
        int del = rec(i, j-1, s1, s2);
        int rep = rec(i-1, j-1, s1, s2);

        return 1 + Math.min(ins, Math.min(del, rep));
    }


}