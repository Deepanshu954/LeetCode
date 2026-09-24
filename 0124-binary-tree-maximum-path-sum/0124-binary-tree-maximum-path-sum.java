class Solution {
    int ans = (int)-1e9;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return ans;
    }

    private int helper(TreeNode node) {
        if(node == null) return 0;

        int left = helper(node.left);
        int right = helper(node.right);

        left = Math.max(left, 0);
        right = Math.max(right, 0);

        int pathSum = left + right + node.val;

        ans = Math.max(ans, pathSum);

        return Math.max(left, right) + node.val;
    }
}