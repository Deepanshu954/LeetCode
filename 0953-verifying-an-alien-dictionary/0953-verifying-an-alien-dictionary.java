class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < 26; i++) {
            map.put(order.charAt(i), i);
        }

        for (int j = 0; j < words.length - 1; j++) {
            String word1 = words[j];
            String word2 = words[j + 1];

            // ❌ This compares references, not content. Must use equals().
            if (word1.equals(word2)) continue;

            int len = Math.min(word1.length(), word2.length());
            boolean differenceFound = false;

            for (int i = 0; i < len; i++) {
                char ch1 = word1.charAt(i);
                char ch2 = word2.charAt(i);

                if (ch1 != ch2) {
                    if (map.get(ch1) > map.get(ch2)) return false;
                    differenceFound = true;
                    break;
                }
            }

            // Only check length if all chars matched and word1 is longer
            if (!differenceFound && word1.length() > word2.length()) return false;
        }

        return true;
    }
}