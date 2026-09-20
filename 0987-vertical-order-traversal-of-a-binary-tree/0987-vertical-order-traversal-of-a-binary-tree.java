class Solution {

    class TreeInfo {
        TreeNode node;
        int row;
        int col;

        public TreeInfo(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) return res;

        // col -> row -> values
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        Queue<TreeInfo> q = new LinkedList<>();
        q.offer(new TreeInfo(root, 0, 0));

        while (!q.isEmpty()) {
            TreeInfo curr = q.poll();

            TreeNode node = curr.node;
            int row = curr.row;
            int col = curr.col;

            map
                .computeIfAbsent(col, k -> new TreeMap<>())
                .computeIfAbsent(row, k -> new PriorityQueue<>())
                .offer(node.val);

            // left
            if (node.left != null) {
                q.offer(new TreeInfo(node.left, row + 1, col - 1));
            }

            // right
            if (node.right != null) {
                q.offer(new TreeInfo(node.right, row + 1, col + 1));
            }
        }

        for (TreeMap<Integer, PriorityQueue<Integer>> rows : map.values()) {
            List<Integer> column = new ArrayList<>();

            for (PriorityQueue<Integer> pq : rows.values()) {
                while (!pq.isEmpty()) {
                    column.add(pq.poll());
                }
            }

            res.add(column);
        }

        return res;
    }
}