class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs) {
            String s = sort2(str);

            if(!map.containsKey(s)) {
                map.put(s, new ArrayList<>());
            }

            map.get(s).add(str);
        }

        List<List<String>> res = new ArrayList<>();

        // for(String key : map.keySet()) {
        //     res.add(map.get(key));
        // }
        res.addAll(map.values());

        return res;

    }

    private String sort1(String str) {
        char[] arr = str.toCharArray();
        Arrays.sort(arr);

        String sorted = new String(arr);
        return sorted;
    }

    private String sort2(String str) {
        int[] freq = new int[26];

        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            freq[ch - 'a']++;
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < 26; i++) {
            while(freq[i]--> 0) sb.append((char)(i + 'a'));
        }

        return sb.toString();
    }
}