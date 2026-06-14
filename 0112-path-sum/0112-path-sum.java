class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        return helper(root, sum);
    }

    private boolean helper(TreeNode root, int sum) {
        if(root == null) return false;

        if(root.left == null && root.right == null) {
            return root.val == sum;
        }


        return helper(root.left, sum - root.val) || helper(root.right, sum - root.val);
    }
}