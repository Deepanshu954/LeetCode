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
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        Deque<TreeNode> dq = new LinkedList<>();
        dq.offerFirst(root);

        int depth = 0;

        while (!dq.isEmpty()) {
            int size = dq.size();
            depth++;

            for (int i = 0; i < size; i++) {
                TreeNode node = dq.pollLast();

                if(node.left == null && node.right == null) return depth;

                if (node.left != null) dq.offerFirst(node.left);
                if (node.right != null) dq.offerFirst(node.right);
            }
        }
        return -1;
    }
}


/*

class Solution {
    public int minDepth(TreeNode root) {
        return helper(root);
    }

    private int helper(TreeNode node) {
        if(node == null) return 0;

        int leftH = helper(node.left);
        int rightH = helper(node.right);

        if(leftH == 0 || rightH == 0) return Math.max(leftH, rightH) + 1;

        return Math.min(leftH, rightH) + 1;
    }
}

*/