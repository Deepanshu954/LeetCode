class Solution {
    public int minAddToMakeValid(String s) {
        if(s.length() == 0) return 0;
        int cnt = 0;

        Deque<Character> dq = new ArrayDeque<>();

        for(char ch : s.toCharArray()) {
            if(ch == '(') dq.addFirst(ch);
            else {
                if(!dq.isEmpty() && dq.peekFirst() == '(') dq.removeFirst();
                else cnt++;
            }
        }

        return dq.size() + cnt;
        
    }
}