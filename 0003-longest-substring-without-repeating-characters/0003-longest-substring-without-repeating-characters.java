class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() < 2) return s.length();
        Set<Character> set = new HashSet<>();

        int left = 0;
        int max = 0;

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            while(set.contains(ch)) set.remove(s.charAt(left++));

            set.add(ch);

            if(max < (i - left + 1)) max = i - left + 1;
        }

        return max;
    }
}