class Solution {
    private int d;
    public int diameterOfBinaryTree(TreeNode root) {
        d = 0;

        helper(root);
        return d;
    }

    private int helper(TreeNode root) {
        if(root == null) return 0;

        int left = helper(root.left);
        int right = helper(root.right);

        d = Math.max(d, left + right);

        return 1 + Math.max(left, right);
    }
}