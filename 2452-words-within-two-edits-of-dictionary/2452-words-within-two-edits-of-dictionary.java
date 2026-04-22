class Solution {
    public List<String> twoEditWords(String[] queries, String[] dict) {
        List<String> list = new ArrayList<>();

        int n = queries.length;

        for(String q : queries) {
            for(String d : dict) {
                if(isValid(q,d)) {
                    list.add(q);
                    break;
                }
            }
        }
        
        return list;
    }

    private boolean isValid(String str, String dict) {
        int cnt = 0;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) != dict.charAt(i)) cnt++;
        }

        return cnt <= 2;
    }
}