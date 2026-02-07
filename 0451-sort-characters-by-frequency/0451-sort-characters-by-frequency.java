class Solution {
    public String frequencySort(String s) {
        int[] freqL = new int[26]; // a-z
        int[] freqU = new int[26]; // A-Z

        // 1. Count frequencies
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                freqL[ch - 'a']++;
            } else if (ch >= 'A' && ch <= 'Z') {
                freqU[ch - 'A']++;
            }
        }

        // 2. Sort characters by frequency
        List<Character> list = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) list.add(c);
        for (char c = 'A'; c <= 'Z'; c++) list.add(c);

        list.sort((a, b) -> {
            int fa = Character.isLowerCase(a) ? freqL[a - 'a'] : freqU[a - 'A'];
            int fb = Character.isLowerCase(b) ? freqL[b - 'a'] : freqU[b - 'A'];
            return fb - fa;
        });

        // 3. Build result
        StringBuilder sb = new StringBuilder();
        for (char c : list) {
            int count = Character.isLowerCase(c) ? freqL[c - 'a'] : freqU[c - 'A'];
            while (count-- > 0) sb.append(c);
        }

        return sb.toString();
    }
}