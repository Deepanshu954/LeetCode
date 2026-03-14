class Solution {
    public String frequencySort(String s) {
        int[] freq = new int[128];

        // 1. Count frequency
        for (char c : s.toCharArray()) freq[c]++;

        // 2. Store characters that appear
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < 128; i++) {
            list.add((char) i);
            // if (freq[i] > 0) {
            //     list.add((char) i);
            // }
        }

        // 3. Sort by frequency (desc)
        list.sort((a, b) -> freq[b] - freq[a]);

        // 4. Build result
        StringBuilder sb = new StringBuilder();
        for (char c : list) {
            for (int i = 0; i < freq[c]; i++) {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}