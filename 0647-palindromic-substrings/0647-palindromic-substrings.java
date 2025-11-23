// class Solution {

//     boolean isPalindrome(String str){
//         int left = 0, right = str.length() - 1;

//         while(left <= right){
//             if(str.charAt(left) != str.charAt(right))return false;
//             left++; right--;
//         }
//         return true;
//     }

//     public int countSubstrings(String s) {
//         int n = s.length();
//         int cnt = 0;

//         for(int i = 0; i < n; i++) {
//             for(int j = i + 1; j <= n; j++) {
//                 String sub = s.substring(i,j);
//                 if(isPalindrome(sub)) cnt++;
//             }
//         }
//         return cnt;
//     }
// }

class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int cnt = 0;

        for(int center = 0;  center < 2*n - 1; center++){
            int left = center/2;
            int right = left + center % 2;

            while(left >= 0 && right < n && s.charAt(left) == s.charAt(right)){
                cnt++; left--; right++;
            }
        }
        
        return cnt;
    }
}