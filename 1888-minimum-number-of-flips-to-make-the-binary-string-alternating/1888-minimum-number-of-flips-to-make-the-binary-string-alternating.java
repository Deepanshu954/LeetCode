class Solution {
    public int minFlips(String s) {
        int flip1 = 0;
        int flip2 = 0;

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(c != (i % 2 == 0 ? '0' : '1')) flip1++;
            if(c != (i % 2 == 0 ? '1' : '0')) flip2++;
        }

        return Math.min(flip1, flip2);
    }
}