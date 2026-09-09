class Solution {
    public long countCommas(long n) {
        if(n < 1e3)
            return 0;

        if(n < 1e6) 
            return (n - 999);

        if(n < 1e9) 
            return (n - ((long)1e6 - 1)) * 2 + (long)(1e6 - 1e3);

        if(n < 1e12) 
            return  (n - ((long)1e9 - 1)) * 3 +  (long)( (1e9 - 1e6) * 2 + (1e6 - 1e3));

        if(n < 1e15) 
            return  (n - ((long)1e12 - 1)) * 4 + (long)( (1e12 - 1e9) * 3 + (1e9 - 1e6) * 2 + (1e6 - 1e3));

        if(n == 1e15) 
            return (long)( (1e15 - 1e12) * 4 + (1e12 - 1e9) * 3 + (1e9 - 1e6) * 2 + (1e6 - 1e3)) + 5;


        return -1;
    }
}