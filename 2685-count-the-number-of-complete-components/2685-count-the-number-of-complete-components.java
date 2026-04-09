class Solution {
    class DSU {
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
            // if(parent[x] != x) {
            //     parent[x] = find(parent[x]);
            // }
            // return parent[x];

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

        // Step 1: Build components
        for(int[] e : edges) {
            dsu.union(e[0], e[1]);
        }

        // Step 2: Count nodes in each component
        int[] nodeCount = new int[n];
        for(int i = 0; i < n; i++) {
            int parent = dsu.find(i);
            nodeCount[parent]++;
        }

        // Step 3: Count edges in each component
        int[] edgeCount = new int[n];
        for(int[] e : edges) {
            int parent = dsu.find(e[0]);
            edgeCount[parent]++;
        }

        // Step 4: Check complete components
        int ans = 0;
        for(int i = 0; i < n; i++) {
            if(nodeCount[i] == 0) continue;

            int nodes = nodeCount[i];
            int edgesNeeded = nodes * (nodes - 1) / 2;

            if(edgeCount[i] == edgesNeeded) {
                ans++;
            }
        }

        return ans;
    }
}