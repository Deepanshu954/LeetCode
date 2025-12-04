class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int sl = s.length(), pl = p.length();
        if(sl < pl) return list;
        int[] freq = new int[26];

        for(int i = 0; i < pl; i++){
            freq[s.charAt(i) - 'a']++;
            freq[p.charAt(i) - 'a']--;
        }

        if(isAnagram(freq)) list.add(0);

        for(int i = pl; i < sl; i++){
            freq[s.charAt(i) - 'a']++;
            freq[s.charAt(i - pl) - 'a']--;
            
            if(isAnagram(freq)) list.add(i - pl + 1);
        }

        return list;
        
    }

    public static boolean isAnagram(int[] freq){
        for(int f : freq) if(f != 0) return false;
        return true;
    }
}