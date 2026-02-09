class Solution {
    public boolean isValid(String s) {
        Deque<Character> dq = new ArrayDeque<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                dq.addFirst(ch);
            } else {
                if (dq.isEmpty()) return false;

                if (ch == ')' && dq.peekFirst() == '(') dq.removeFirst();
                else if (ch == '}' && dq.peekFirst() == '{') dq.removeFirst();
                else if (ch == ']' && dq.peekFirst() == '[') dq.removeFirst();
                else return false;
            }
        }
        return dq.isEmpty();
    }
}