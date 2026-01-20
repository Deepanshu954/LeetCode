class Solution {
    public boolean isIsomorphic(String s, String t) {

        Character[] arr = new Character[26];

        for(int i = 0;  i < s.length(); i++) {
            arr[s.charAt(i) - 'a'] = t.charAt(i);
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s.length(); i++) {
            sb.append(arr[s.charAt(i) - 'a']);
        }
        
        return sb.toString().equals(t);
    }
}