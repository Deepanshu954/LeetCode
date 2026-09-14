class Solution {
    public int largestInteger(int num) {
        PriorityQueue<Integer> odd = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> even = new PriorityQueue<>((a, b) -> b - a);
        

        String s = Integer.toString(num);
        char[] digits = s.toCharArray();
        
        for (char c : digits) {
            int val = c - '0';

            if (val % 2 == 0) even.offer(val);
            else odd.offer(val);
        }
        
        int res = 0;
        for (char c : digits) {
            int val = c - '0';

            res *= 10;
            if (val % 2 == 0) res += even.poll();
            else res += odd.poll();
        }
        
        return res;
    }
}
