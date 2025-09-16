class Solution {
    public int reverse(int x) {
        int num = x;
        boolean turn = false;
        if(num < 0){
            turn = true;
            num = -1 * num;
        }

        int rev = 0;

        while(num != 0) {
            int dig = num % 10;
            num /= 10;

            if(rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && dig >  7)) return 0;
            if(rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && dig < -8)) return 0;

            rev = rev*10 + dig;
        }

        if(turn){
            return -1 * rev;
        }else{
            return rev;
        }
    }
}