class Solution {
    public boolean isNumber(String s) {
        int n = s.length();
        int i = 0;

        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            i++;
        }

        boolean digit = false;
        boolean dot = false;

        while (i < n) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                digit = true;
            } else if (c == '.') {
                if (dot) return false;
                dot = true;
            } else {
                break;
            }
            i++;
        }

        if (!digit) return false;

        if (i < n && (s.charAt(i) == 'e' || s.charAt(i) == 'E')) {
            i++;

            if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
                i++;
            }

            boolean expDigit = false;

            while (i < n) {
                char c = s.charAt(i);
                if (!Character.isDigit(c)) return false;
                expDigit = true;
                i++;
            }

            if (!expDigit) return false;
        }

        return i == n;
    }
}