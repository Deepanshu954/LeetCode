class Solution {
    public String frequencySort(String s) {
        int[] freq = new int[128]; // ASCII range

        // 1. Count frequency
        for (char c : s.toCharArray()) {
            freq[c]++;
        }

        // 2. Buckets by frequency
        List<Character>[] buckets = new ArrayList[s.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            buckets[i] = new ArrayList<>();
        }

        // 3. Fill buckets
        for (int c = 0; c < 128; c++) {
            if (freq[c] > 0) {
                buckets[freq[c]].add((char) c);
            }
        }

        // 4. Build result (high → low)
        StringBuilder sb = new StringBuilder();
        for (int f = s.length(); f > 0; f--) {
            for (char c : buckets[f]) {
                sb.append(String.valueOf(c).repeat(f));
            }
        }

        return sb.toString();
    }
}