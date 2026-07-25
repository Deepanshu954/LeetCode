class Solution {
    public int addDigits(int num) {
        int res = num;

        while(res >= 10) {
            int sum = 0;

            while(res != 0) {
                sum += res % 10;
                res /= 10;
            }

            res = sum;
        }

        return res;
    }
}