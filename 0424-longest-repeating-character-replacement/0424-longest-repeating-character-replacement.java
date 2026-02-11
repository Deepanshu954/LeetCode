class Solution {
    public int characterReplacement(String s, int k) {
        if (s.length() == 0 || s.length() <= k) return s.length();

        int[] freq = new int[26];

        // initialize first k window
        for (int i = 0; i < k && i < s.length(); i++) {
            freq[s.charAt(i) - 'A']++;
        }

        int left = 0;
        int max = k;   // at least k length possible

        for (int right = k; right < s.length(); right++) {

            freq[s.charAt(right) - 'A']++;

            while (!check(freq, right - left + 1, k)) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            int localMax = right - left + 1;
            if (localMax > max) max = localMax;
        }

        return max;
    }

    private boolean check(int[] nums, int windowSize, int k) {

        int maxFreq = 0;

        for (int num : nums) {
            maxFreq = Math.max(maxFreq, num);
        }

        return (windowSize - maxFreq) <= k;
    }
}