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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Deque<TreeNode> dq = new LinkedList<>();

        dq.addFirst(root);

        while(!dq.isEmpty()) {
            int size = dq.size();
            List<Integer> list = new ArrayList<>();

            for(int i = 0; i < size; i++) {
                TreeNode node = dq.removeLast();
                list.add(node.val);

                if(node.left != null) dq.addFirst(node.left);
                if(node.right != null) dq.addFirst(node.right);
            }
            result.add(list);
        }


        return result;
    }
}