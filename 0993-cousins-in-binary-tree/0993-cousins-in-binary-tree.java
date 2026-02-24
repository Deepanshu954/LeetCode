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
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;

        Deque<TreeNode> dq = new LinkedList<>();
        dq.addFirst(root);

        TreeNode nodeX = null;
        TreeNode nodeY = null;

        while(!dq.isEmpty()) {
            int size = dq.size();

            boolean findX = false;
            boolean findY = false;


            for(int i = 0; i < size; i++) {
                TreeNode node = dq.removeLast();
                if(node.val == x) {
                    findX = true;
                    nodeX = node;
                }
                if(node.val == y) {
                    findY = true;
                    nodeY = node;
                }

                if(node.left != null) dq.addFirst(node.left);
                if(node.right != null) dq.addFirst(node.right);
            }

            if(findX && findY) {
                return (height(nodeX) - height(nodeY)) == 0;
            }

        }

        return false;
    }

    private int height(TreeNode root) {
        if (root == null) return 0;

        int left = height(root.left);
        int right = height(root.right);

        return Math.max(left, right) + 1;
    }
}