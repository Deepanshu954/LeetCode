import java.util.*;

class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";

        Map<Character, Integer> mapT = new HashMap<>();
        for (char ch : t.toCharArray())
            mapT.put(ch, mapT.getOrDefault(ch, 0) + 1);

        Map<Character, Integer> mapS = new HashMap<>();
        int have = 0, need = mapT.size();
        int left = 0, minLen = Integer.MAX_VALUE;
        int start = 0; // starting index of min window

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            mapS.put(ch, mapS.getOrDefault(ch, 0) + 1);

            if (mapT.containsKey(ch) && mapS.get(ch).intValue() == mapT.get(ch).intValue()) {
                have++;
            }

            while (have == need) {
                // update min window
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                // shrink from left
                char leftChar = s.charAt(left);
                mapS.put(leftChar, mapS.get(leftChar) - 1);
                if (mapT.containsKey(leftChar) && mapS.get(leftChar) < mapT.get(leftChar)) {
                    have--;
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}