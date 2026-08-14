class Solution {
    public int maximumLengthSubstring(String s) {
        int max = 0;
        int left = 0;

        int[] freq = new int[26];

        for(int right = 0; right < s.length(); right++) {
            int ch = s.charAt(right) - 'a';
            freq[ch]++;

            while(freq[ch] > 2) {
                freq[s.charAt(left++) - 'a']--;
            }

            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}