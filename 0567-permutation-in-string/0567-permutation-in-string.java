class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        int[] freq = new int[26];

        for(int i = 0; i < s1.length(); i++){
            freq[s1.charAt(i) - 'a']++;
            freq[s2.charAt(i) - 'a']--;
        }

        if(checkZero(freq)) return true;

        for(int i = s1.length(); i < s2.length();i++){
            freq[s2.charAt(i) - 'a']--;
            freq[s2.charAt(i - s1.length()) - 'a']++;

            if(checkZero(freq)) return true;
        }
        return false;
    }
    public static boolean checkZero(int[] arr){
        for(int a : arr){
            if(a != 0) return false;
        }
        return true;
    }
}