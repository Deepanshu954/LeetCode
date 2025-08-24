class Solution {
    public boolean isPalindrome(String s) {
        String str = s.toLowerCase();
        int i = 0, j = str.length() - 1;

        while (i < j) {
            char left = str.charAt(i);
            char right = str.charAt(j);

            if (!Character.isLetterOrDigit(left)) {
                i++;
            } else if (!Character.isLetterOrDigit(right)) {
                j--;
            } else {
                if (left != right) return false;
                i++;
                j--;
            }
        }
        return true;
    }
}