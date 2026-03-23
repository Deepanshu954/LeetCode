class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // Step 1: Build adjacency list
        List<int[]>[] adj = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        
        for (int[] time : times) {
            int u = time[0];
            int v = time[1];
            int w = time[2];
            adj[u].add(new int[]{v, w}); // {neighbor, weight}
        }
        
        // Step 2: Apply Dijkstra template
        int[] dist = new int[n + 1];  // n+1 because nodes are 1-indexed
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;  // src = k
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, k});  // {distance, node}
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int d = curr[0];  // current distance
            int u = curr[1];  // current node
            
            // Skip if we've already processed this node with better distance
            if (d > dist[u]) continue;
            
            // Relax all edges from u
            for (int[] edge : adj[u]) {
                int v = edge[0];      // neighbor node
                int weight = edge[1]; // edge weight
                
                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.offer(new int[]{dist[v], v});
                }
            }
        }
        
        // Step 3: Find maximum distance (skip index 0)
        int maxDist = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;  // unreachable node exists
            }
            maxDist = Math.max(maxDist, dist[i]);
        }
        
        return maxDist;
    }
}

/*
```

## Key Mappings to Your Template:

| Template Variable | Network Delay Mapping |
|-------------------|----------------------|
| `src` | `k` (starting node) |
| `n` | `n + 1` (1-indexed nodes) |
| `adj[u]` | Built from `times[][]` |
| `edge[0]` | Neighbor node (`v`) |
| `edge[1]` | Edge weight |

## Example Walkthrough:

**Input:** `times = [[2,1,1],[2,3,1],[3,4,1]]`, `n = 4`, `k = 2`
```
Graph: 2 → 1 (weight 1)
       2 → 3 (weight 1)
       3 → 4 (weight 1)

*/