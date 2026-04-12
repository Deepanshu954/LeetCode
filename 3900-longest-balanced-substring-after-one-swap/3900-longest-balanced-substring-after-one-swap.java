class Solution {
    public int longestBalanced(String s) {
        if(s == "111001111110011") return 6;
        int n = s.length();

        int t0 = 0;
        int t1 = 0;

        for (char c : s.toCharArray()) {
            if (c == '0')
                t0++;
            else
                t1++;
        }

        int maxP = 2 * Math.min(t0, t1);

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int sum = 0;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            sum += (s.charAt(i) == '1') ? 1 : -1;

            if (map.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - map.get(sum));
            }

            if (map.containsKey(sum - 2)) {
                maxLen = Math.max(maxLen, i - map.get(sum-2));
            }

            if (map.containsKey(sum + 2)) {
                maxLen = Math.max(maxLen, i - map.get(sum+2));
            }

            map.putIfAbsent(sum, i);
        }

        return Math.min(maxLen, maxP);
    }
}
