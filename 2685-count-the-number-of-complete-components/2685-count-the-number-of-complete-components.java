class Solution {
    public class DSU {
        int[] parent, size;

        DSU(int n) {
            parent = new int[n];
            size = new int[n];

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
        }
    }
    public int countCompleteComponents(int n, int[][] edges) {
        DSU dsu = new DSU(n);

        // crerate conn
        for(int[] e : edges) {
            dsu.union(e[0], e[1]);
        }

        // node counts
        int[] nodeCount = new int[n];

        for(int i = 0; i < n; i++) {
            int p = dsu.find(i);
            nodeCount[p]++;
        }

        // edge Count
        int[] edgeCount = new int[n];

        for(int[] e :edges) {
            int p = dsu.find(e[0]);
            edgeCount[p]++;
        }

        // ans
        int ans = 0;

        for(int i = 0; i < n; i++) {
            if(nodeCount[i] == 0) continue;

            int node = nodeCount[i];
            int edge = edgeCount[i];

            int expected = node * (node - 1) / 2;

            if(edge == expected) ans++;
        }

        return ans;
    }
}