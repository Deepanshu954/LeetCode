class Solution {
    public int reverse(int x)
    {
        long num = 0,dig;
        boolean togle = false;

        if(x < 0)
        {
            x = x *(-1);
            togle = true;
        }

        while(x > 0)
        {
            dig = x % 10;
            x /= 10;
            num = (num * 10) + dig;
        }

        if(togle) num = num *(-1);

        int ans = (int) num;
        return ans;
    }
}