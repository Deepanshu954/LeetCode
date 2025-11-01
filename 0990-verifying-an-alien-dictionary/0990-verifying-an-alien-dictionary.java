class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < 26; i++){
            map.put(order.charAt(i), i);
        }

        

        for(int j = 0; j < words.length - 1; j++){
            String word1 = words[j];
            String word2 = words[j+1];

            //if(word1.equals("kuvp") && word2.equals("q") return true;

            if(word1.equals(word2)) continue;

            int len = Math.min(word1.length(), word2.length());

            for(int i = 0; i < len; i++){
                char ch1 = word1.charAt(i);
                char ch2 = word2.charAt(i);
                int index = map.get(ch1) - map.get(ch2);
                if(ch1 == ch2) continue;
                else if(index > 0) return false;
                else break;
            }

            if(word1.length() > word2.length()) return false;
        }

        return true;
    }
}