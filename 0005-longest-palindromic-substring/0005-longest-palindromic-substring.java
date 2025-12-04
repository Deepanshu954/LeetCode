class Solution {
    private int start = 0;
    private int maxLength = 0;

    public String longestPalindrome(String s) {
        int n = s.length();
        if (n < 2) return s;

        for (int i = 0; i < n; i++) {
            // Case 1: Odd length (Center is s[i])
            expandAroundCenter(s, i, i);

            // Case 2: Even length (Center is s[i] and s[i+1])
            expandAroundCenter(s, i, i + 1);
        }

        return s.substring(start, start + maxLength);
    }

    private void expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        // The current palindrome found is s.substring(left + 1, right)
        // Its length is (right - 1) - (left + 1) + 1 = right - left - 1

        int currentLength = right - left - 1;

        if (currentLength > maxLength) {
            maxLength = currentLength;
            start = left + 1; // start index of the new longest palindrome
        }
    }
}