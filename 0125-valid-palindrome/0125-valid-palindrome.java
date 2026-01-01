class Solution {
    public boolean isPalindrome(String s) {
        //String s = str.toLowerCase();
        int i = 0;
        int j = s.length() - 1;

        if(s.equals(" ")) return true;

        while(i < j){
            while(i < j && !Character.isLetterOrDigit(s.charAt(i))) i++;
            while(i < j && !Character.isLetterOrDigit(s.charAt(j))) j--;

            //if(s.charAt(i) != s.charAt(j)) return false;
            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) return false;
            i++;
            j--;
        }

        return true;
    }
}

