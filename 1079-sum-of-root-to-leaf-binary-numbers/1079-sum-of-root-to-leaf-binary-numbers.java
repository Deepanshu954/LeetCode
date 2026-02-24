class Solution {
    public int sumRootToLeaf(TreeNode root) {
        return helper(root, 0);
    }

    private int helper(TreeNode root, int num) {
        if (root == null) return 0;

        // shift left by 1 (binary) and add current bit
        num = (num << 1) | root.val;

        // if leaf node
        if (root.left == null && root.right == null) {
            return num;
        }

        int left = helper(root.left, num);
        int right = helper(root.right, num);

        return left + right;
    }
}