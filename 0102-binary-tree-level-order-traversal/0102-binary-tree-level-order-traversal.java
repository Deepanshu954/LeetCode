class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.offerLast(root);

        while (!dq.isEmpty()) {
            int size = dq.size();
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = dq.pollFirst();
                list.add(node.val);

                if (node.left != null) dq.offerLast(node.left);
                if (node.right != null) dq.offerLast(node.right);
            }
            res.add(list);
        }

        return res;
    }
}