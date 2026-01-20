class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] mapST = new int[26];
        int[] mapTS = new int[26];

        for (int i = 0; i < s.length(); i++) {
            int a = s.charAt(i) - 'a';
            int b = t.charAt(i) - 'a';

            if (mapST[a] == 0 && mapTS[b] == 0) {
                mapST[a] = b + 1;
                mapTS[b] = a + 1;
            } else if (mapST[a] != b + 1 || mapTS[b] != a + 1) {
                return false;
            }
        }
        return true;
    }
}