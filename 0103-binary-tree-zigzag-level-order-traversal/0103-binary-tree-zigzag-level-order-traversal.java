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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        Deque<TreeNode> dq = new LinkedList<>();

        dq.addFirst(root);

        while(!dq.isEmpty()) {
            int size = dq.size();

            List<Integer> l = new ArrayList<>();

            for(int i = 0; i < size; i++) {
                TreeNode node = dq.removeLast();
                l.add(node.val);

                if(node.right != null) dq.addFirst(node.right);
                if(node.left != null) dq.addFirst(node.left);
                
            }

            result.add(l);

            if(dq.isEmpty()) return result;





            size = dq.size();


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


/*

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        Deque<TreeNode> dq = new LinkedList<>();
        boolean turn = true;

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

            turn = !turn;

            if(turn) Collections.reverse(list);

            result.add(list);
        }

        return result;
    }
}

*/