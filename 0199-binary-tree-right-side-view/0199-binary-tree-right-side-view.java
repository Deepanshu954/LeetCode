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
    public List<Integer> rightSideView(TreeNode node) {
        List<Integer> list = new ArrayList<>();
        if(node == null) return list;
        int cnt = 0;

        TreeNode root = node;

        while(root != null) {
            cnt++;
            list.add(root.val);
            if(root.right != null) {
                root = root.right;
                continue;
            } else {
                if(root.left != null)
                    root = root.left;
                else break;
            }
        }

        root = node;

        if(root.left == null) return list;
        root = root.left;

        while(cnt--> 1 && root != null) {

            if(root.right != null) {
                root = root.right;
                continue;
            } else {
                if(root.left != null)
                    root = root.left;
                else break;
            }
        }

        if(root == null) return list;

        while(root != null) {

            list.add(root.val);
            if(root.right != null) {
                root = root.right;
                continue;
            } else {
                if(root.left != null)
                    root = root.left;
                else break;
            }
        }

        return list;
    }
}