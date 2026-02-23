class Solution {

    public int myAtoi(String s) {
        int index = skipSpaces(s, 0);

        if (index >= s.length()) return 0;

        int sign = 1;
        if (s.charAt(index) == '-') {
            sign = -1;
            index++;
        } else if (s.charAt(index) == '+') {
            index++;
        }

        return convert(s, index, sign, 0);
    }

    private int skipSpaces(String s, int i) {
        if (i >= s.length() || s.charAt(i) != ' ')
            return i;
        return skipSpaces(s, i + 1);
    }

    private int convert(String s, int i, int sign, long result) {

        if (i >= s.length() || !Character.isDigit(s.charAt(i)))
            return (int)(sign * result);

        int digit = s.charAt(i) - '0';
        result = result * 10 + digit;

        // Overflow handling
        if (sign == 1 && result > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;

        if (sign == -1 && -result < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        return convert(s, i + 1, sign, result);
    }
}