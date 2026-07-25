class Solution {
    public int maxProduct(int val) {
        int n = val;

        int[] nums = new int[10];

        while(n != 0) {
            int dig = n % 10;
            nums[dig]++;

            n /= 10;
        }

        nums[0] = 0;
        int num1 = 0;
        int num2 = 0;

        for(int i = 9; i > 0; i--) {
            if(nums[i] > 0) {
                num1 = i;
                nums[i]--;
                break;
            }
        }

        for(int i = 9; i > 0; i--) {
            if(nums[i] > 0) {
                num2 = i;
                break;
            }
        }

        return num1 * num2;
    }
}