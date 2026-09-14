class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res) {
        if(root == null) return;

        Deque<TreeNode> s = new ArrayDeque<>();
        s.push(root);

        while(!s.isEmpty()) {
            TreeNode node = s.pop();
            res.add(node.val);

            if(node.right != null) s.push(node.right);
            if(node.left != null) s.push(node.left);
        }
    }
}