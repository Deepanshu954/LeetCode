class Solution {
    public boolean isSubsequence(String s, String t) {

        int sLen = s.length();
        int tLen = t.length();

        if(sLen > tLen) return false;
        if(sLen == 0) return true;

        int index = 0;

        for(int i = 0; i < tLen; i++){
            if(s.charAt(index) == t.charAt(i)) index++;
            if(sLen == index) return true;
        }
        return false;
    }
}