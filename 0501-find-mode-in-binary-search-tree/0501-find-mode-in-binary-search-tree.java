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
    private List<Integer> list = new ArrayList<>();
    public int[] findMode(TreeNode root) {
        Set<Integer> set = new HashSet<>();

        helper(root, set);
        return ;
    }

    private void helper(TreeNode root, Set<Integer> set) {
        if(root == null) return;

        helper(root.left);

        if(set.contains(root.val)) list.add(root.val);
        
        helper(root.right);
    }
}