class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Deque<Integer> dq = new ArrayDeque<>();

        int[] res = new int[n];

        for(int i = 0; i < n; i++) {
            while(!dq.isEmpty() && temperatures[dq.peek()] < temperatures[i]) {
                
                int idx = dq.pop();
                res[idx] = i - idx;
            }

            dq.push(i);
        }

        return res;
    }
}