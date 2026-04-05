class Solution {
    public class Pair {
        int node;
        double prob;

        Pair(int node, double prob) {
            this.node = node;
            this.prob = prob;
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<Pair>[] adj = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double w = succProb[i];

            adj[u].add(new Pair(v, w));
            adj[v].add(new Pair(u, w));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b) -> Double.compare(b.prob, a.prob)
        );

        double[] maxProb = new double[n];
        maxProb[start] = 1.0;

        pq.offer(new Pair(start, 1.0));

        while(!pq.isEmpty()) {
            Pair curr = pq.poll();
            int node = curr.node;
            double prob = curr.prob;

            if(node == end) return prob;
            if(prob < maxProb[node]) continue;

            for(Pair nei : adj[node]) {
                int next = nei.node;
                double newProb = prob * nei.prob;

                if(newProb > maxProb[next]) {
                    maxProb[next] = newProb;
                    pq.offer(new Pair(next, newProb));
                }
            }
        }
        return 0.0;
    }
}