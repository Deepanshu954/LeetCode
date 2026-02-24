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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if(root == null) return result;

        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.offerFirst(root);

        while(!dq.isEmpty()) {
            int size = dq.size();
            double sum = 0;


            for(int i = 0; i < size; i++) {
                TreeNode node = dq.removeLast();

                sum += node.val;

                if(node.left != null) dq.addFirst(node.left);
                if(node.right != null) dq.addFirst(node.right);
            }

            result.add(sum/size);
        }

        return result;
    }
}