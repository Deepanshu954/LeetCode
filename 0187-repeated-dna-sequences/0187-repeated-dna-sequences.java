class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() < 10) return res;

        int n = s.length();
        int mask = (1 << 20) - 1; // keep 20 bits
        int hash = 0;

        // map chars to 2-bit values
        int[] map = new int[128];
        map['A'] = 0;
        map['C'] = 1;
        map['G'] = 2;
        map['T'] = 3;

        Set<Integer> seen = new HashSet<>();
        Set<Integer> added = new HashSet<>();

        for (int i = 0; i < n; i++) {
            hash = ((hash << 2) | map[s.charAt(i)]) & mask; // roll and keep 20 bits

            if (i < 9) continue; // wait until first full window (i = 9)

            if (!seen.add(hash)) {
                // already seen: add to result set if not added before
                if (added.add(hash)) {
                    res.add(s.substring(i - 9, i + 1));
                }
            }
        }

        return res;
    }
}