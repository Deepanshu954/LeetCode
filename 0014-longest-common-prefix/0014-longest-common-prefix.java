class Solution {
    public String longestCommonPrefix(String[] strs) {
        String ans = strs[0];

        for(int i = 1; i < strs.length; i++){
            String word = strs[i];

            int index = 0;
            int min = Math.min(word.length(), ans.length());

            while(index < min && word.charAt(index) == ans.charAt(index)) index++;


            //int index = 0;


            ans = ans.substring(0, index);
            if(ans == "") return "";
        }

        return ans;
    }
}