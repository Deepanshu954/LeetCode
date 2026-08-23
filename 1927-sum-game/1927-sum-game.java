class Solution {
    public boolean sumGame(String num) {
        int n = num.length();

        int leftSum = 0;
        int rightSum = 0;
        int leftOp = 0;
        int rightOp = 0;

        for(int i = 0; i < n/2; i++) {
            int ch = num.charAt(i);

            if(ch == '?') leftOp++;
            else leftSum += (ch - '0');
        }

        for(int i = n/2; i < n; i++) {
            int ch = num.charAt(i);

            if(ch == '?') rightOp++;
            else rightSum += (ch - '0');
        }

        return (leftSum - rightSum ) * 2 != (rightOp - leftOp) * 9;
    }
}