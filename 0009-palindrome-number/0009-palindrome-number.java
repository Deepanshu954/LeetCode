class Solution {
    public boolean isPalindrome(int x) {
        int num = Math.abs(x);
        int rev = 0;
        
        while(num != 0) {
            int dig = num % 10;
            num = num / 10;
            
            rev = (10 * rev) + dig;
        }
        
        return rev == x;
    }
}