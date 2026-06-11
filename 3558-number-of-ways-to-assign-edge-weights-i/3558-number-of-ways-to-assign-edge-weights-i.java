import java.util.*;

class Solution {
    static final int MOD = 1_000_000_007;

    public int assignEdgeWeights(int[][] edges) {
        // Build graph
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] e : edges) {
            adj.computeIfAbsent(e[0], k -> new ArrayList<>()).add(e[1]);
            adj.computeIfAbsent(e[1], k -> new ArrayList<>()).add(e[0]);
        }

        // BFS to find max depth from node 1
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        q.add(1);
        visited.add(1);

        int depth = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int node = q.poll();

                for (int nei : adj.getOrDefault(node, new ArrayList<>())) {
                    if (!visited.contains(nei)) {
                        visited.add(nei);
                        q.add(nei);
                    }
                }
            }
            depth++;
        }

        int d = depth - 1; // edges count

        return modPow(2, d - 1);
    }

    private int modPow(long base, int exp) {
        long res = 1;
        base %= MOD;

        while (exp > 0) {
            if ((exp & 1) == 1) res = (res * base) % MOD;
            base = (base * base) % MOD;
            exp >>= 1;
        }

        return (int) res;
    }
}