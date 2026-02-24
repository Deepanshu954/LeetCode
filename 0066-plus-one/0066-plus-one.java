class Solution {
    public int[] plusOne(int[] digits) {
        int index = -1;

        // Find first non-9 digit from right
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

        // Increase that digit
        digits[index] += 1;

        // Make all digits after it zero
        Arrays.fill(digits, index + 1, digits.length, 0);

        return digits;
    }
}