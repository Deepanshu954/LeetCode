class Solution {
    public int myAtoi(String s) {

        int ans = 0;
        boolean turn = false;
        boolean started = false;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == ' ' && !started) continue;

            if (ch == '-' && !started) {
                turn = true;
                started = true;
            }

            else if (ch == '+' && !started) {
                started = true;
            }
            
            else if (ch >= '0' && ch <= '9') {
                started = true;

                if (ans > Integer.MAX_VALUE / 10 ||
                   (ans == Integer.MAX_VALUE / 10 && (ch - '0') > 7))
                    return turn ? Integer.MIN_VALUE : Integer.MAX_VALUE;

                ans = ans * 10 + (ch - '0');
            }
            else {
                break;
            }
        }

        return turn ? -ans : ans;
    }
}