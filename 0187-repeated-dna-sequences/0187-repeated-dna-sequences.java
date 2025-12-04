class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() < 10) return res;

        Set<String> seen = new HashSet<>();
        Set<String> repeated = new HashSet<>();

        for (int i = 0; i + 10 <= s.length(); i++) {
            String sub = s.substring(i, i + 10);
            if (!seen.add(sub)) {          // add returns false if already present
                repeated.add(sub);
            }
        }

        res.addAll(repeated);
        return res;
    }
}