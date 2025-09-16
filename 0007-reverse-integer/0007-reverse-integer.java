class Solution {
    public int reverse(int x) {
        long num = x;
        boolean turn = false;
        if(num < 0){
            turn = true;
            num = -1 * num;
        }

        long rev = 0;

        while(num != 0) {
            long dig = num % 10;
            num /= 10;
            rev = rev*10 + dig;
        }

        int ans = (int) rev;

        if(turn){
            return -1 * ans;
        }else{
            return ans;
        }
    }
}