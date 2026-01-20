class Solution {
    public String largestOddNumber(String num) {

        int pos = 0;

        for(int i = 0; i < num.length(); i++) {
            int val = num.charAt(i) - '0';

            if(val % 2 == 1) pos = i+1;
        }
        return num.substring(0, pos);
    }
}