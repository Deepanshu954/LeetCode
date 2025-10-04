class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] lastSeen = new int[256]; // store last seen index of each char
        Arrays.fill(lastSeen, -1);

        int n = s.length();
        int maxLen = 0, left = 0;

        for (int right = 0; right < n; right++) {
            char ch = s.charAt(right);

            if (lastSeen[ch] >= left) {
                left = lastSeen[ch] + 1;
            }

            lastSeen[ch] = right;
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}