/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int d = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        d = 0;
        helper(root);
        return d;
    }

    private int helper(TreeNode root) {
        if(root == null) return 0 ;

        int l = helper(root.left);
        int r = helper(root.right);

        d = Math.max(d,l + r);
        return Math.max(l,r) + 1;
    }
}