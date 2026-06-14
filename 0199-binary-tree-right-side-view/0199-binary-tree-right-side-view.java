class Solution {
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;

        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.addLast(root);

        while (!dq.isEmpty()) {
            int size = dq.size();

            for (int i = 0; i < size; i++) {
                TreeNode curr = dq.removeFirst();

                if (i + 1 == size)
                    list.add(curr.val);

                if (curr.left != null)
                    dq.addLast(curr.left);
                if (curr.right != null)
                    dq.addLast(curr.right);
            }
        }

        return list;
    }
}