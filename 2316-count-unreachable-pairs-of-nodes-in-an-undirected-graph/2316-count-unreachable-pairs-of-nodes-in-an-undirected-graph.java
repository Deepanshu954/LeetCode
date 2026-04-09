class Solution {
        class DSU {
        int[] parent, size;
        int components;

        DSU(int n) {
            parent = new int[n];
            size = new int[n];
            components = n;

            for(int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int find(int x) {
            if(parent[x] == x) return x;
            return parent[x] = find(parent[x]);
        }

        void union(int u, int v) {
            int pu = find(u);
            int pv = find(v);

            if(pu == pv) return;

            if(size[pu] < size[pv]) {
                parent[pu] = pv;
                size[pv] += size[pu];
            } else {
                parent[pv] = pu;
                size[pu] += size[pv];
            }

            components--;
        }

        boolean isConnected(int u, int v) {
            return find(u) == find(v);
        }

        int getComponents() {
            return components;
        }
    }

    public long countPairs(int n, int[][] edges) {
        DSU dsu = new DSU(n);

        for(int[] e : edges) {
            dsu.union(e[0], e[1]);
        }

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            int p = dsu.find(i);
            map.put(p, map.getOrDefault(p, 0) + 1);
        }

        long res = 0;
        long sum = 0;

        for(int size : map.values()) {
            res += sum * size;
            sum += size;
        }

        return res;
    }

}