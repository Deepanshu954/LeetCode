class Solution {
    public int reverse(int x)
    {
        long num = 0,dig;

        while(x != 0)
        {
            dig = x % 10;
            x /= 10;
            num = (num * 10) + dig;
        }

        int ans = (int) num;
        return ans;
    }
}