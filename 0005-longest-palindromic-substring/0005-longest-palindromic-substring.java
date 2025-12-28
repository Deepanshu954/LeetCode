// // Brute Force
// class Solution {
//     public String longestPalindrome(String s) {
//         if(s.length() < 2) return s;
//         String ans = "";

//         for(int i = 0; i < s.length(); i++){
//             for(int j = i; j < s.length(); j++){
//                 String sub = s.substring(i,j+1);
//                 if(isPalindrome(sub) && ans.length() < sub.length()) ans = sub;
//             }
//         }
//         return ans;
//     }

//     public static boolean isPalindrome(String s){
//         int left = 0, right = s.length() - 1;

//         while(left < right) if(s.charAt(left++) != s.charAt(right--)) return false;
//         return true;
//     }
// }

class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int start = 0;
        int maxLen = 1;

        for(int center = 0; center < 2*n -1; center++){
            int left = center/2;
            int right = left + center % 2;

            while(left >= 0 && right < n && s.charAt(left) == s.charAt(right)){
                int len = right - left + 1;

                if(len > maxLen){
                    maxLen = len;
                    start = left;
                }
                left--;
                right++;
            }
        }
        return s.substring(start, start + maxLen);
    }
}