class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String s : strs){
            int[] freq = new int[26];
            for(char ch : s.toCharArray()) freq[ch - 'a']++;

            StringBuilder key = new StringBuilder();
            for(int f : freq) key.append(f).append('#');

            map.computeIfAbsent(key.toString(), k -> new ArrayList<>()).add(s);

        }

        return new ArrayList<>(map.values());
    }
}