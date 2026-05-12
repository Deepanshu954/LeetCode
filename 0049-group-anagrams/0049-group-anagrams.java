class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs) {
            String s = sortS(str);

            if(!map.containsKey(s)) {
                map.put(s, new ArrayList<>());
            }

            map.get(s).add(str);
        }

        List<List<String>> res = new ArrayList<>();

        for(String key : map.keySet()) {
            res.add(map.get(key));
        }

        return res;

    }

    private String sortS(String str) {
        char[] arr = str.toCharArray();
        Arrays.sort(arr);

        String sorted = new String(arr);
        return sorted;
    }
}