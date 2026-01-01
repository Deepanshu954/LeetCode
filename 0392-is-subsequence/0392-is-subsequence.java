class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length() > t.length()) return false;
        if(s.equals(t)) return true;
        if(s.equals("")) return true;

        int index = 0;

        for(int i = 0; i < t.length(); i++){
            if(index == s.length() - 1) return true;

            if(s.charAt(index) == t.charAt(i)) index++;
            else continue;
        }

        if(index == s.length() - 1) return true;
        
        return false;
    }
}