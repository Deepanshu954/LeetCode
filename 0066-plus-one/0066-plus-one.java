class Solution {
    public int[] plusOne(int[] digits) {
        int index = digits.length - 1;

        if(digits[index] != 9) {
            digits[index] += 1;
            return digits;
        }

        for(int i = digits.length - 1; i >= 0; i--) {
            if(digits[i] != 9) {
                index = i;
                break;
            }
        }

        if(index == digits.length - 1) {
            int[] arr = new int[digits.length + 1];
            Arrays.fill(arr, 0);
            arr[0] = 1;

            return arr;
        }

        digits[index] += 1;
        Arrays.fill(digits, 0 ,index + 1, digits.length);

        return digits;
    }
}