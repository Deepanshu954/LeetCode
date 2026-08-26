class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        String res = "";
        int minLen = 200;
        int cnt = 0;

        int left = 0;
        for(int right = 0; right < n; right++) {
            if(s.charAt(right) == '1') cnt++;

            while(cnt > k || (left <= right && s.charAt(left) == '0')) {
                if(s.charAt(left) == '1') cnt--;
                left++;
            }

            if(cnt == k) {
                int currentLen = right - left + 1;
                String currentStr = s.substring(left, right + 1);

                // Check 1: Found a strictly shorter valid substring
                // Check 2: Found a same-length substring that is alphabetically smaller
                if (currentLen < minLen) {
                    minLen = currentLen;
                    res = currentStr;
                } else if (currentLen == minLen && currentStr.compareTo(res) < 0) {
                    res = currentStr;
                }
            }
        }

        return res;
    }
}
