class Solution {
    public int getSum(int a, int b) {

        /*
        Problem:
        Add two integers without using + or - operators.

        Idea:
        Binary addition has two parts:
        1. Sum without carry
        2. Carry

        Example:
            1 + 1 = 0 (carry 1)

        We simulate this using bit operations.
        */

        int sum = 0, carry = 0;

        /*
        We repeat the process until there is no carry left.
        When carry becomes 0, the result is stored in 'a'.
        */
        while (b != 0) {

            /*
            Step 1: Calculate sum WITHOUT carry.

            XOR behaves exactly like addition without carry.

            Truth table:
            a  b  a^b
            0  0   0
            0  1   1
            1  0   1
            1  1   0  (carry generated)

            Example:
                101
            XOR 011
            --------
                110
            */
            sum = a ^ b;

            /*
            Step 2: Calculate carry.

            Carry occurs only when both bits are 1.

            AND operator detects this.

            Example:
                101
            AND 011
            --------
                001

            Since carry affects the NEXT bit position,
            we shift it left by 1.
            */
            carry = (a & b) << 1;

            /*
            Step 3: Update values for next iteration.

            'a' becomes the temporary sum.
            'b' becomes the carry.

            Now we repeat the process until carry = 0.
            */
            a = sum;
            b = carry;
        }

        /*
        When carry becomes 0, the final result
        is stored in 'a'.
        */
        return a;
    }
}