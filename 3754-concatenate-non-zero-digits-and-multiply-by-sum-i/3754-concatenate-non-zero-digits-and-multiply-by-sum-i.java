class Solution {
    public long sumAndMultiply(int n) {
        if(n == 0) return 0;

        long num = 0;
        long sum = 0;

        while(n != 0) {
            int dig = n % 10;
            n /= 10;

            if(dig > 0) {
                num = num* 10 + dig;
            }

            sum += dig;
        }

        String str = String.valueOf(num);
        str = new StringBuilder(str).reverse().toString(); 
        num = Integer.parseInt(str);


        return num * sum;
    }
}