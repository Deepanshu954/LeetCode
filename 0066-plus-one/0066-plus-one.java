class Solution {
    public int[] plusOne(int[] digits) {
        int index = -1;

        for(int i = digits.length - 1; i >= 0; i--) {
            if(digits[i] != 9) {
                index = i;
                break;
            }
        }

        // If all digits are 9
        if(index == -1) {
            int[] arr = new int[digits.length + 1];
            arr[0] = 1;
            return arr;
        }

        digits[index] += 1;

        Arrays.fill(digits, index + 1, digits.length, 0);

        return digits;
    }
}