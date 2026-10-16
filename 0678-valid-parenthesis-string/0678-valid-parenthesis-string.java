class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();
        int low = 0;
        int high = 0;

        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if(ch == '(') {
                low++;
                high++;
            } else if(ch == ')') {
                low = (low < 1) ? 0 : --low;
                high--;
            } else {
                low = (low < 1) ? 0 : --low;
                high++;
            }

            if(high < 0) return false;
        }

        return low == 0;
    }
}