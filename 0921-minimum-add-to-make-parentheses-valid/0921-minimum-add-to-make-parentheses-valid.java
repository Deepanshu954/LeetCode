class Solution {
    public int minAddToMakeValid(String s) {
        if(s.length() == 0) return 0;
        int a = 0;
        int b = 0;

        for(char ch : s.toCharArray()) {
            if(ch == '(') a++;
            else b++;
        }

        if(a > b) return a - b;

        return b - a;
        
    }
}