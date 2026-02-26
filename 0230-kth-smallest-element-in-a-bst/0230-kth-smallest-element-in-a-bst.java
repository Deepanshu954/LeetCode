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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> res = new ArrayList<>();

        inorder(root, res, k);

        return res.get(k-1);
    }

    private void inorder(TreeNode root, List<Integer> res,int k) {
        if(root == null || res.size() == k) return;

        inorder(root.left, res, k);
        res.add(root.val);
        inorder(root.right, res, k);
    }
}