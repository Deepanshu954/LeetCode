class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        return dfs(root, val);
    }

    private TreeNode dfs(TreeNode node, int val) {
        if (node == null)
            return new TreeNode(val);
        else if (val < node.val)
            node.left = dfs(node.left, val);
        else if (val > node.val)
            node.right = dfs(node.right, val);

        return node;
    }
}
