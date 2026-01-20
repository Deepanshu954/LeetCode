class Solution {
    public String removeOuterParentheses(String s) {

        int count = 0;

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if(count == 0 && ch == '(') {
                count++;
                continue;
            } else if(count == 1 && ch == ')'){
                count--;
                continue;
            } else {
                if(ch == '(') count++;
                else count--;
            }

            sb.append(ch);
        }
        return sb.toString();
    }
}