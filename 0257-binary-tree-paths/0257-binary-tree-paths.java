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

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        helper(root, "", result);
        return result;
    }

    private void helper(TreeNode root, String path, List<String> result) {
        if (root == null) return;

        if (!path.isEmpty()) path += "->";
        path += root.val;

        if (root.left == null && root.right == null) {
            result.add(path);
            return;
        }

        helper(root.left, path, result);
        helper(root.right, path, result);
    }
}