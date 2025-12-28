class Solution {
    public String longestPalindrome(String s) {
        if(s.length() < 2) return s;
        String ans = "";

        for(int i = 0; i < s.length(); i++){
            for(int j = i+1; j < s.length(); j++){
                String sub = s.substring(i,j);
                if(isPalindrome(sub)){
                    if(ans.length() < sub.length()) ans = sub;
                }
            }
        }
        return ans;
    }

    public static boolean isPalindrome(String s){
        int left = 0;
        int right = s.length() - 1;

        while(left < right){
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}