class Solution
{
    public:
        bool isPalindrome(int x)
        {
            if (x < 0) return false;
            long long num = x;
            long long digit = 0;

            while (num != 0)
            {
                int sum = num % 10;
                num = num / 10;
                digit = digit * 10 + sum;
            }

            return x == digit;
        }
};