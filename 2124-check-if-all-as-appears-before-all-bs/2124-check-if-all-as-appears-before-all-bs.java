class Solution {
    public boolean checkString(String s) {
        int n = s.length();
        int b = 0;

        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if(ch == 'a' && b > 0) return false;
            if(ch == 'b') b++;
        }

        return true;
    }
}