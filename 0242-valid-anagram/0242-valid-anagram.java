class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int n = s.length();

        int count = 0;

        for(int i = 0; i < n; i++) {
            count = count + (s.charAt(i) - 'a');
            count = count - (t.charAt(i) - 'a');
        }

        if(count == 0) return true;
        else return false;
    }
}