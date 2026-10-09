class Solution {
    public int minInsertions(String s) {
        int left = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') left++;
            else {

                if (i + 1 < s.length() && s.charAt(i + 1) == ')')  i++;
                else res++;

                if (left > 0) left--;
                else res++;
            }
        }
        
        res += left * 2;
        return res;
    }
}
