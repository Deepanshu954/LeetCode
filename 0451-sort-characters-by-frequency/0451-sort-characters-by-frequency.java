class Solution {
    public String frequencySort(String s) {
        int[] freqL = new int[26]; // a-z
        int[] freqU = new int[26]; // A-Z

        // 1. Count frequency
        for (char ch : s.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                freqL[ch - 'a']++;
            } else if (ch >= 'A' && ch <= 'Z') {
                freqU[ch - 'A']++;
            }
        }

        // 2. Buckets: index = frequency
        List<Character>[] buckets = new ArrayList[s.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            buckets[i] = new ArrayList<>();
        }

        // 3. Fill buckets
        for (int i = 0; i < 26; i++) {
            if (freqL[i] > 0) buckets[freqL[i]].add((char) (i + 'a'));
            if (freqU[i] > 0) buckets[freqU[i]].add((char) (i + 'A'));
        }

        // 4. Build result (high freq → low)
        StringBuilder sb = new StringBuilder();
        for (int f = s.length(); f > 0; f--) {
            for (char c : buckets[f]) {
                for (int k = 0; k < f; k++) {
                    sb.append(c);
                }
            }
        }

        return sb.toString();
    }
}