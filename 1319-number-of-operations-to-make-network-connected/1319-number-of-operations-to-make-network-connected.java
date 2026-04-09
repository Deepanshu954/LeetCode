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

    public int makeConnected(int n, int[][] edges) {
        int val = edges.length;
        if( val + 1 < n) return -1;
        
        DSU dsu = new DSU(n);

        for(int[] e : edges) {
            int u = e[0];
            int v = e[1];

            dsu.union(u,v);
        }

        // // No Of Nodes
        // int[] countNodes = new int[n];

        // for(int i = 0; i < n; i++) {
        //     int p = find(i);
        //     countNodes[p]++;
        // }

        // // No Of Nodes

        // int[] countEdges = new int[n];

        // for(int[] e : edges) {
        //     int p = find[e[0]];
        //     countEdges[p]++;
        // }

        return dsu.getComponents() - 1;
    }
}













