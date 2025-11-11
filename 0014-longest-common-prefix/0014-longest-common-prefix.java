/*
class Solution {
    public String longestCommonPrefix(String[] strs) {
        String first = strs[0];
        int prefixLen = first.length();

        for (int i = 1; i < strs.length; i++) {
            String word = strs[i];
            int j = 0;
            int min = Math.min(prefixLen, word.length());

            while (j < min && first.charAt(j) == word.charAt(j)) j++;

            prefixLen = j;
            if (prefixLen == 0) return "";
        }

        return first.substring(0, prefixLen);
    }
}
*/

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        String prefix = strs[0];

        for(int i = 1; i < strs.length; i++){

            while(!strs[i].startsWith(prefix)){
                prefix = prefix.substring(0, prefix.length() - 1);
                if(prefix.isEmpty()) return "";
            }
        }

        return prefix;
    }
}