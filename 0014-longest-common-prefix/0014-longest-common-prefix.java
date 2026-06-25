class Solution {
    public String longestCommonPrefix(String[] strs) {
        String pre = strs[0];

        for(String str : strs) {
            if(str.startsWith(pre)) continue;
            if(pre == "") return "";

            while(!str.startsWith(pre)) {
                pre = pre.substring(0, pre.length() - 1);
            }
        }

        return pre;
    }
}