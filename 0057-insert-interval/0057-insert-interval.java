class Solution {
    public int[][] insert(int[][] inv, int[] newI) {
        List<int[]> res = new ArrayList<>();

        int n = inv.length;
        int idx = 0;

        while(idx < n && inv[idx][1] < newI[0]) res.add(inv[idx++]);

        while(idx < n && inv[idx][0] <= newI[1]) {
            newI[0] = Math.min(newI[0], inv[idx][0]);
            newI[1] = Math.max(newI[1], inv[idx][1]);
            idx++;
        }

        res.add(newI);

        while(idx < n) res.add(inv[idx++]);

        return res.toArray(new int[0][]);
    }
}