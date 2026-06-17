class Solution {
    public char processStr(String s, long k) {
        String str = process(s);

        long size = str.length();
        if(k >= size) return '.';

        return str.charAt((int) k);
        
    }

    private String process(String s) {
         StringBuilder sb = new StringBuilder();

        for(char ch : s.toCharArray()) {
            if(ch == '*') {
                if(sb.length() > 0) sb.deleteCharAt(sb.length() - 1);
            }
            else if(ch == '#') sb.append(sb.toString());
            else if(ch == '%') sb.reverse();
            else sb.append(ch);
        }

        return sb.toString();
    }
}