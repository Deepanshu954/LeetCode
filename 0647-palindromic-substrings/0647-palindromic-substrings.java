class Solution {
    public int countSubstrings(String s) {
        // Step 1: Transform: "abba" -> "^#a#b#b#a#$"
        char[] t = preprocess(s);
        int n = t.length;
        
        int[] p = new int[n];  // palindrome radius array
        int center = 0, right = 0;
        int count = 0;

        // Step 2: Core Manacher loop
        for (int i = 1; i < n - 1; i++) {
            int mirror = 2 * center - i;      // mirror index wrt center

            if (i < right)
                p[i] = Math.min(right - i, p[mirror]);

            // try expanding around i
            while (t[i + 1 + p[i]] == t[i - 1 - p[i]]) {
                p[i]++;
            }

            // update center & right boundary
            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }

            // Every increase in radius contributes (p[i] + 1) / 2 palindromes
            count += (p[i] + 1) / 2;
        }

        return count;
    }

    // add #'s to convert even & odd palindromes into one form
    private char[] preprocess(String s) {
        char[] t = new char[s.length() * 2 + 3];
        t[0] = '^';
        t[t.length - 1] = '$';

        int idx = 1;
        for (char c : s.toCharArray()) {
            t[idx++] = '#';
            t[idx++] = c;
        }
        t[idx] = '#';

        return t;
    }
}