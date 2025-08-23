class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int n = s.length();

        int[] arr = new int[26];

        for(int i = 0; i < n; i++) {
            arr[s.charAt(i) - 'a']++;
            arr[t.charAt(i) - 'a']--;
        }

        for(int a : arr) {
            if(a != 0) return false;
        }

        return true;
    }
}