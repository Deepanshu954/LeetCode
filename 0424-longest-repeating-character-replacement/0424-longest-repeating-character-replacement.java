class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int left = 0;
        int maxFreq = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {

            int f = ++freq[s.charAt(right) - 'A'];

            if(maxFreq < f) maxFreq = f;

            while ((right - left + 1) - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            int len = right - left + 1;
            if(maxLen < len) maxLen = len;
        }

        return maxLen;
    }
}