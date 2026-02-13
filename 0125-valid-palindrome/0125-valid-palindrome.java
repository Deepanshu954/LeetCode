// class Solution {
//     public boolean isPalindrome(String s) {
//         int i = 0;
//         int j = s.length() - 1;

//         if(s.equals(" ")) return true;

//         while(i < j){
//             while(i < j && !Character.isLetterOrDigit(s.charAt(i))) i++;
//             while(i < j && !Character.isLetterOrDigit(s.charAt(j))) j--;

//             if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) return false;
//             i++;
//             j--;
//         }

//         return true;
//     }
// }



class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();

        return helper(s, 0, s.length() - 1);
    }

    private boolean helper(String s, int left, int right) {
        if(left >= right) return true;

        if(!Character.isLetterOrDigit(s.charAt(left)))  return helper(s, left +1, right);
        else if(!Character.isLetterOrDigit(s.charAt(right))) return helper(s, left, right - 1);
        else if(s.charAt(left) != s.charAt(right)) return false;

        return helper(s, left + 1, right - 1);

        //return true;
    }
}