
class Solution {
    public int minDepth(TreeNode root) {
        return helper(root);
    }

    private int helper(TreeNode node) {
        if(node == null) return 0;

        int leftH = helper(node.left);
        int rightH = helper(node.right);

        if(leftH == 0 || rightH == 0) return Math.max(leftH, rightH) + 1;

        return Math.min(leftH, rightH) + 1;
    }
}

