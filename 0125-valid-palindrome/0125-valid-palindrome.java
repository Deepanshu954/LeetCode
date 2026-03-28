class Solution {
    public boolean isPalindrome(String s) {
        String str = s.toLowerCase();

        int left = 0;
        int right = s.length() - 1;

        while(left < right) {
            if(str.charAt(left) < 'a' || str.charAt(left) > 'z') {
                left++;
                continue;
            }
            if(str.charAt(right) < 'a' || str.charAt(right) > 'z') {
                right--;
                continue;
            }

            if(str.charAt(left) != str.charAt(right)) return false;

            left++;
            right--;
        }

        return true;
    }
}