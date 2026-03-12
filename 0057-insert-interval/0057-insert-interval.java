class Solution {
    public int[][] insert(int[][] inv, int[] new) {
        List<int[]> res = new ArrayList<>();

        int n = inv.length;
        int idx = 0;

        while(i < n && inv[idx][1] < new[0]) res.add(inv[idx++]);

        while(i < n && inv[idx][0] < new[1]) {
            new[0] = Math.min(new[0], inv[idx][0]);
            new[1] = Math.max(new[1], inv[idx][1]);
            idx++;
        }

        while(i < n) res.add(inv[idx++]);

        return res.toArray(new int[0][]);
    }
}