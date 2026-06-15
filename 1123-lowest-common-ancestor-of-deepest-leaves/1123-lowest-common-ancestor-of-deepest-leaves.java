class Solution {
    int depth;
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        depth = depth(root);
        return search(root, 0);
    }

    private TreeNode search(TreeNode root, int curr) {
        if(root == null) return null;
        if(curr == depth - 1) return root;

        TreeNode left = search(root.left, curr+1);
        TreeNode right = search(root.right, curr+1);

        if(left != null && right != null) return root;
        return left != null ? left : right;
    }

    private int depth(TreeNode node) {
        if(node == null) return 0;
        return 1 + Math.max(depth(node.left), depth(node.right));
    }
}