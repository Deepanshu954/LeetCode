public class Solution {
    public int maxStability(int n, int[][] edges, int k) {
        UnionFind initial_uf = new UnionFind(n);
        // Observation 1: Find minimum s_i for must-have edges.
        int min_s = Integer.MAX_VALUE;
        for (int[] e : edges) {
            int u = e[0], v = e[1], s = e[2], must = e[3];
            if (must == 0) continue;
            min_s = Math.min(min_s, s);
            // Observation 2: The must-have edges form a cycle.
            if (!initial_uf.union(u, v)) return -1;
        }
        int[] baseRank = initial_uf.rank.clone();
        int[] baseRoot = initial_uf.root.clone();

        java.util.function.IntPredicate check = (min_stability) -> {
            // Observation 1
            if (min_stability > min_s) return false;

            // This copies the initial state, where all `must-have edges`
            // are connected.
            UnionFind uf = new UnionFind(n);
            uf.rank = baseRank.clone();
            uf.root = baseRoot.clone();

            // Observation 3: List of edges to consider an upgrade
            List<int[]> upgrade = new ArrayList<>();
            for (int[] e : edges) {
                int u = e[0], v = e[1], s = e[2], must = e[3];
                if (must == 1) continue;
                // Observation 3
                if (s >= min_stability) {
                    uf.union(u, v);
                } else if (s * 2 >= min_stability) {
                    upgrade.add(new int[]{u, v});
                }
            }

            int r = k;  // number of upgrades remaining
            for (int[] p : upgrade) {
                int u = p[0], v = p[1];
                if (uf.isConnected(u, v)) continue;
                if (r == 0) return false;
                uf.union(u, v);
                --r;
            }

            // Observation 3
            int root0 = uf.find(0);
            for (int i = 1; i < n; ++i)
                if (uf.find(i) != root0) return false;
            return true;
        };

        int right = 0;
        for (int[] e : edges) right = Math.max(right, e[2]);
        right *= 2;
        int left = -1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (check.test(mid))
                left = mid;
            else
                right = mid - 1;
        }
        return left;
    }
}