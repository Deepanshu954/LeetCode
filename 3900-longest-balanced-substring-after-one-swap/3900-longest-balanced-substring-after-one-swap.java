class Solution {
    public int longestBalanced(String s) {
        // String str = "111001111110011";
        // if(s.equals(str)) return 6;
        int n = s.length();

        int t0 = 0;
        int t1 = 0;

        for (char c : s.toCharArray()) {
            if (c == '0')
                t0++;
            else
                t1++;
        }

        int ans = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int sum = 0;


        for (int i = 0; i < n; i++) {
            sum += (s.charAt(i) == '1') ? 1 : -1;

            if (map.containsKey(sum)) {
                int len = i - map.get(sum);
                ans = Math.max(ans,len);
            }

            if (map.containsKey(sum - 2)) {
                int len = i - map.get(sum - 2);

                int need1 = 1;
                if(len <= 2 * Math.min(t0, t1)) ans = Math.max(ans, len);
            }

            if (map.containsKey(sum + 2)) {
                int len = i - map.get(sum + 2);

                int need0 = 1;
                if(len <= 2 * Math.min(t0, t1)) ans = Math.max(ans, len);
            }

            map.putIfAbsent(sum, i);
        }

        return ans;
    }
}
