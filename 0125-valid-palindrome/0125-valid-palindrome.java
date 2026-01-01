class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        if(s.equals(" ")) return true;

        while(left < right){
            while(left < right && !Character.isLetterOrDigit(s.charAt(left))) left++;
            while(left < right && !Character.isLetterOrDigit(s.charAt(right))) right--;

            char l = s.charAt(left);
            char r = s.charAt(right);

            if(l == r);
            else if(l + 33 == r + 1);
            else if(l + 1 == r + 33);
            else return false;

            left++;
            right--;
        }

        return true;
    }
}