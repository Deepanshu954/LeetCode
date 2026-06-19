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
    int cnt = 0;
    int val;
    public int goodNodes(TreeNode root) {
        val = root.val;
        dfs(root);
        return cnt;
    }

    private void dfs(TreeNode root) {
        if(root == null) return;

        dfs(root.left);
        if(val <= root.val) cnt++;
        dfs(root.right);
    }
}