class Solution {
public:
    int fib(int n) 
    {
        if(n <= 1) return n;
        int a{0}, b{1},next;

        for(int i = 2; i <= n; i++)
        {
            next = a + b;
            a = b;
            b = next;
        }
        return b;
    }
};