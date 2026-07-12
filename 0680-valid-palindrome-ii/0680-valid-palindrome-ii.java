import java.util.*;

public class Solution {
    public boolean validPalindrome(String string) {
        int l = 0, r = string.length() - 1;

        while (l < r) {
            if (string.charAt(l) != string.charAt(r)) {
                return check(string, l + 1, r) || check(string, l, r - 1);
            }
            l++;
            r--;
        }

        return true;
    }

    private boolean check(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }
}