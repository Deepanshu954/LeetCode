class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();

        dfs(0, graph, new ArrayList<>(), res);

        return res;
    }

    private void dfs(int node, int[][] graph, List<Integer> path, List<List<Integer>> res) {
        path.add(node);

        if(node == graph.length - 1) res.add(new ArrayList<>(path));
        else for(int nei : graph[node]) dfs(nei, graph, path, res);

        path.remove(path.size() - 1);
    }
}