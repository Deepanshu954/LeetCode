class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxlength= 0;
        Set<Character> charset = new HashSet<>();
        int left = 0;

        for(int right= 0;right<s.length();right++){
            if(!charset.contains(s.charAt(right))){
                charset.add(s.charAt(right));
                maxlength = Math.max(maxlength, right-left+1);
            }else{
                while(charset.contains(s.charAt(right))){
                    charset.remove(s.charAt(left));
                    left++;
                }
                charset.add(s.charAt(right));
            }
        }
        return maxlength;
    }
    
}