class Solution {
    public boolean checkPerfectNumber(int num) {
        int ans = 1;
        int n = num;

        if(n % 2 == 1) return false;

        while(n  > 2){
            if(n % 2 == 1) n++;

            n = n/2;
            ans += n;
        }
        
        if(num == ans) return true;
        
        return false;
    }
}