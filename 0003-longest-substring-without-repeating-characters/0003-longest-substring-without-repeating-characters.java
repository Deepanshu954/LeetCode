class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] last = new int[128];      // ASCII
        Arrays.fill(last, -1);

        int maxLen = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            if (last[c] >= left) {
                left = last[c] + 1;     // jump left
            }

            last[c] = right;
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}