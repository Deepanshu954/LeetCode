class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        String ans = "";
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : t.toCharArray()) map.put(ch, map.getOrDefault(ch, 0) + 1);

        int[] freq = new int[128];
        int left = 0;
        int minLen = Integer.MAX_VALUE;

        for(int right = 0; right < s.length(); right++) {
            freq[s.charAt(right)]++;

            // Valid Window -> Try to Shrink it
            while(check(freq, map)) {
                int len = right - left + 1;
                
                if(len < minLen) {
                    minLen = len;
                    ans = s.substring(left, right + 1);
                }

                freq[s.charAt(left)]--;
                left++;
            }
        }
        return ans;
    }

    private boolean check(int[] nums, HashMap<Character, Integer> map) {
        for(Character key : map.keySet()) {
            if(map.get(key) > nums[key]) return false;
        }
        return true;
    }
}