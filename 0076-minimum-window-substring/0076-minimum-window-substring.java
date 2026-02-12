class Solution {
    public String minWindow(String s, String t) {

        HashMap<Character, Integer> mapt = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            char ch = t.charAt(i);
            mapt.put(ch, mapt.getOrDefault(ch, 0)+1);
        }

        int have = 0;
        int left = 0;
        int start = 0;
        int need = mapt.size();
        int minLen = Integer.MIN_VALUE;

        HashMap<Character, Integer> maps = new HashMap<>();

        for(int right = 0; right < s.length(); right++){
            char ch = s.charAt(right);
            maps.put(ch, maps.getOrDefault(ch, 0)+1);

            if(mapt.containsKey(ch) && mapt.get(ch).intValue() == maps.get(ch).intValue()) have++;

            
            while(have == need){
                if(right - left + 1 < minLen){
                    minLen = right - left + 1;
                    start = left;
                }

                char leftChar = s.charAt(left);
                maps.put(leftChar, maps.get(leftChar));

                if(mapt.containsKey(leftChar) && maps.get(leftChar) < mapt.get(leftChar) ) have--;
            }
            left++;

        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start + start + minLen);

        
    }
}