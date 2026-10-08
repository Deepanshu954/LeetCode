class Solution {
    private List<Integer> sq;
    private int res = 10000;

    public int numSquares(int n) {
        if(n < 4) return n;
        sq = new ArrayList<>();

        for(int i = 1; i <= 100; i++) {
            int val = i*i;

            if(val == n) return 1;
            if(val > n) break;

            sq.add(val);
        }

        helper(n, sq.size() - 1, 0);
        return res;
    }

    private void helper(int n, int idx, int cnt) {
        if(cnt >= res) return;
        if(n == 0) {
            res = Math.min(res, cnt);
            return;
        }
        if(idx < 0) return;

        int val = sq.get(idx);

        if(n >= val) helper(n - val, idx, cnt + 1);
        helper(n, idx - 1, cnt);
    }
}