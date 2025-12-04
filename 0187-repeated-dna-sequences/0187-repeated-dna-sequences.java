class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> list = new ArrayList<>();
        if(s == null || s.length() < 10) return list;

        Set<String> seen = new HashSet<>();
        Set<String> repeat = new HashSet<>();

        for(int i = 0; i+10 <= s.length(); i++){
            String sub = s.substring(i, i+10);

            if(!seen.add(sub)) repeat.add(sub);
        }

        list.addAll(repeat);
        return list;
    }
}