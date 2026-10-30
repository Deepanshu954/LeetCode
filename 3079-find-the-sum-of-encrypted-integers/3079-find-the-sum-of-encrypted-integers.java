class Solution {
    public int sumOfEncryptedInt(int[] nums) {
        int res = 0;

        for(int num : nums) {
            res += encrypt(num);
        }

        return res;
    }

    private int encrypt(int num) {
        int max = 0;
        int res = 0;
        int size = 0;

        while(num != 0) {
            int dig = num % 10;
            num /= 10;

            max = Math.max(max, dig);
            size++;
        }

        for(int i = 0; i < size; i++) {
            res = res * 10 + max;
        }

        return res;
    }
}