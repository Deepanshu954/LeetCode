class Solution {
    public int myAtoi(String s) {
        int index = removeSpace(s, 0);

        if(index >= s.length()) return 0;

        int sign = 1;
        
        if(s.charAt(index) == '-') {sign = -1; index++;}
        else if(s.charAt(index) == '+') {index++;}

        return sign * s2n(s, index, 0);
        
    }

    private int removeSpace(String s, int index) {
        if(index >= s.length() || s.charAt(index) != ' ') return index;
        return removeSpace(s, index + 1);
    }

    private int s2n(String s, int index,int res) {
        
        if(index >= s.length() || !Character.isDigit(s.charAt(index))) return res;

        int digit = s.charAt(index) - '0';
        res = res * 10 + digit;

        return s2n(s, index + 1, res);
    }
}