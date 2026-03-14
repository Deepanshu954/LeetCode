class Solution {
    public String makeGood(String s) {
        Deque<Character> dq = new ArrayDeque<>();

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if(!dq.isEmpty() && Math.abs(dq.peekFirst() - ch) == 32) {
                dq.removeFirst();
            } 
            else {
                dq.addFirst(ch);
            }
        }

        StringBuilder sb = new StringBuilder();

        while(!dq.isEmpty()) {
            sb.append(dq.removeLast());
        }

        return sb.toString();
    }
}