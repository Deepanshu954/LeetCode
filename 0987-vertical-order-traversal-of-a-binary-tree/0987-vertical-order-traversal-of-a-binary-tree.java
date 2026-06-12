class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        rowcolumn(0, 0, root);
        for (TreeMap<Integer, PriorityQueue<Integer>> row : map.values()) {
            List<Integer> colist = new ArrayList<>();
            for (PriorityQueue<Integer> pq : row.values()) {
                while (!pq.isEmpty()) {
                    colist.add(pq.poll());
                }
            }
            ans.add(colist);
        }
        return ans;
    }

    void rowcolumn(int row, int col, TreeNode root) {
        if (root == null) {
            return;
        }
        map.putIfAbsent(col, new TreeMap<>());
        map.get(col).putIfAbsent(row, new PriorityQueue<>());
        map.get(col).get(row).offer(root.val);
        rowcolumn(row + 1, col - 1, root.left);
        rowcolumn(row + 1, col + 1, root.right);

    }

}