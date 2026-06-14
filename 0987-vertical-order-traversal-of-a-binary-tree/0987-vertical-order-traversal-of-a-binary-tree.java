class Solution {
    private TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map;
    private List<List<Integer>> res;

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        map = new TreeMap<>();
        res = new ArrayList<>();

        helper(root, 0, 0);

        for(TreeMap<Integer, PriorityQueue<Integer>> rows : map.values()) {
            List<Integer> list = new ArrayList<>();

            for(PriorityQueue<Integer> pq : rows.values()) {
                while(!pq.isEmpty()) {
                    list.add(pq.poll());
                }
            }

            res.add(list);
        }

        return res;
    }

    private void helper(TreeNode root, int row, int col) {
        if (root == null)
            return;

        map.putIfAbsent(col, new TreeMap<>());
        map.get(col).putIfAbsent(row, new PriorityQueue<>());
        map.get(col).get(row).offer(root.val);

        helper(root.left,  row + 1, col - 1);
        helper(root.right, row + 1, col + 1);
    }
}