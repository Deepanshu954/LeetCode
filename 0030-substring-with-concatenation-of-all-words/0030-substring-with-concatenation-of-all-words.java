class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (words.length == 0) return res;

        int wordLen = words[0].length();
        int totalWords = words.length;
        int totalLen = wordLen * totalWords;

        Set<String> dict = new HashSet<>(Arrays.asList(words));

        for (int start = 0; start + totalLen <= s.length(); start++) {
            Set<String> seen = new HashSet<>();
            int i = start;

            while (i < start + totalLen) {
                String w = s.substring(i, i + wordLen);
                if (!dict.contains(w) || !seen.add(w))
                    break;
                i += wordLen;
            }

            if (seen.size() == totalWords)
                res.add(start);
        }
        return res;
    }
}