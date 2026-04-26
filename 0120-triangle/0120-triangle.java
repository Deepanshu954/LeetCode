class Solution {
    public int minimumTotal(List<List<Integer>> tri) {
        int n = tri.size();

        int minPath = Integer.MAX_VALUE;

        for(int c = 0; c < n; c++) {
            minPath = Math.min(minPath, rec(n-1, c, tri));
        }
        return minPath;
    }

    private int rec(int r, int c, List<List<Integer>> tri) {
        if(r == 0) return tri.get(0).get(0);
        if(c < 0 || c > r) return (int)1e9;

        return tri.get(r).get(c) + Math.min(rec(r-1, c, tri), rec(r-1, c-1, tri));
    }
}