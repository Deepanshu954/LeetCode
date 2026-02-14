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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;

        Deque<TreeNode> dq = new ArrayDeque<>();

        TreeNode curr = root;
        TreeNode prev = null;

        while(curr != null || !dq.isEmpty()) {

            if(curr != null) {

                dq.addFirst(curr);
                curr = curr.left;

            } else {

                curr = dq.peekFirst();
                if(curr.right == null || curr.right == prev) {
                    list.add(dq.removeFirst().val);
                    prev = curr;
                    curr = null;

                } else curr = curr.right;
            }
        }

        return list;
    }
}


/*
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;

        Deque<TreeNode> dq1 = new LinkedList<>();
        Deque<TreeNode> dq2 = new LinkedList<>();

        dq1.addFirst(root);

        while(!dq1.isEmpty()) {
            TreeNode node = dq1.removeFirst();
            dq2.addFirst(node);

            if(node.left  != null) dq1.addFirst(node.left);
            if(node.right != null) dq1.addFirst(node.right);
        }

        while(!dq2.isEmpty()) {
            list.add(dq2.removeFirst().val);
        }

        return list;
    }
}
*/

/*

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        postorder(root, list);
        return list;
    }

    private void postorder(TreeNode root, List<Integer> list) {
        if(root == null) return;

        postorder(root.left, list);
        postorder(root.right, list);
        list.add(root.val);
    }
}

*/