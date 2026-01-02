class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();

        int maxSize = 0;
        int left = 0;
        for(int right = 0; right < s.length(); right++){
            
            while(set.contains(s.charAt(right))) set.remove(s.charAt(left++));

            set.add(s.charAt(right));

            maxSize = Math.max(maxSize, right - left + 1);
        }
        return maxSize;
    }
}