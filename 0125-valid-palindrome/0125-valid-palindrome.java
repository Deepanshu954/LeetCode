class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            char l = s.charAt(left);
            char r = s.charAt(right);

            if (!Character.isLetterOrDigit(l)) {
                left++;
            } else if (!Character.isLetterOrDigit(r)) {
                right--;
            } else {
                if (l != r) {
                    // Check if they are the same letter in different cases
                    // 32 is (1 << 5). XORing with 32 flips the case.
                    if (Character.isLetter(l) && Character.isLetter(r) && (l ^ 32) == r) {
                        // Match found via case flip, continue
                    } else {
                        return false;
                    }
                }
                left++;
                right--;
            }
        }
        return true;
    }
}