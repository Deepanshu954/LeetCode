class Solution {
    public String longestPalindrome(String s) {
        if(s.length() == 0 || s.length() == 1) return s;
        int n = s.length();
        String ans = "";

        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                String subString = s.substring(i,j);

                if(isPalindrome(subString)){
                    if(subString.length() > ans.length()){
                        ans = subString;
                    }
                }

            }
        }
        return ans;
    }

    public static boolean isPalindrome(String str){
        if(str.length() == 0) return true;
        int left = 0;
        int right = str.length() - 1;
        while(left < right){
            if(str.charAt(left) != str.charAt(right)) return false;
            left++;
            right--;
        }

        return true;
    }
}