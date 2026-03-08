class Solution {
    public String removeDuplicates(String s) {
        Deque<Character> dq = new ArrayDeque<>();

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if(!dq.isEmpty() && dq.peekFirst() == ch) {
                dq.removeFirst();
                continue;
            }

            dq.addFirst(ch);
        }

        StringBuilder sb = new StringBuilder();

        while(!dq.isEmpty()) {
            sb.append(dq.removeLast());
        }

        return sb.toString();
    }
}