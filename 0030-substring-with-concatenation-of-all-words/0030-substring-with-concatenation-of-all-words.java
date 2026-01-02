class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<String, Boolean> map = new HashMap<>();
        for(String word : words) map.put(word, false);

        int size = words[0].length();
        int len = words.length;
        String sub = "";

        int index = 0;
        for(int i = 0; i < s.length(); i += size){
            sub = s.subString(i,i + size);

            if(map.get(sub) == false){
                map.put(sub, true);
                index++;
                if(index == len){
                    index = 0;
                    map.replaceAll((k,v) -> false);
                    list.add(i - (words.length * size) + 1);
                }
            } else {
                index = 0;
                map.replaceAll((k,v) -> false);
                i = i - (words.length * size) + 1;
            }
            return list;
        }
    }
}