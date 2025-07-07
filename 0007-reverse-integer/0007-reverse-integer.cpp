class Solution {
public:
    int reverse(int x) 
    {
        long long digit = 0;

        while(x != 0)
        {
            int sum = x % 10;
            x = x / 10;
            digit = digit * 10 + sum;

            // Check for overflow
            if (digit > INT_MAX || digit < INT_MIN) 
                return 0;
        }

        return digit;
    }
};