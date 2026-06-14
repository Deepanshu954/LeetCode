class Solution {
    private int res = 0;
    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return res;
    }

    private void helper(TreeNode root, int num) {
        if(root == null) return;

        num = (10 * num) + root.val;

        if(root.left == null && root.right == null) {
            res += num;
            return;
        }

        helper(root.left, num);
        helper(root.right, num);
    }
}