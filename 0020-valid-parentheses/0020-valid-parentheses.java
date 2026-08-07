class Solution {
    public boolean isValid(String s) {
        if(s.length() % 2 == 1) return false;

        Deque<Character> dq = new ArrayDeque<>();

        for(char ch : s.toCharArray()) {
            if(ch == '(' || ch == '{' || ch == '[') dq.addFirst(ch);
            else {
                if(dq.isEmpty()) return false;
                char c = dq.removeFirst();

                if((c == '(' && ch == ')') || (c == '{' && ch == '}') || (c == '[' && ch == ']')) continue;
                else return false;
            }
        }

        return dq.isEmpty();
    }
}