class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        return check(root) != -1;
    }

    private int check(TreeNode root) {
        if(root == null) return 0;

        int l = check(root.left);
        if(l == -1) return -1;

        int r = check(root.right);
        if(r == -1) return -1;

        if(Math.abs(l - r) > 1) return -1;

        return 1 + Math.max(l, r);
    }
}