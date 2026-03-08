class Solution {
    public int scoreOfParentheses(String s) {
        Deque<Character> dq = new ArrayDeque<>();
        int cnt = 0;

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if(ch == '(') dq.addFirst(ch);
            else if(!dq.isEmpty() && dq.peekFirst() == '(') {
                dq.removeFirst();
                cnt++;
            } else {
                dq.addFirst(')');
            }
        }

        return cnt;
    }
}