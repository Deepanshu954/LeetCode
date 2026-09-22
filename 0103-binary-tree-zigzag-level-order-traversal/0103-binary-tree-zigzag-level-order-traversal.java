class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        boolean odd = false;

        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> curr = new ArrayList<>();

            for(int i = 0; i < size; i++) {
                TreeNode node = q.poll();

                if(odd) curr.addFirst(node.val);
                else curr.add(node.val);

                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }

            res.add(curr); 

            odd = !odd;
        }

        return res;
    }
}


// class Solution {
//     public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
//         List<List<Integer>> res = new ArrayList<>();
//         if(root == null) return res;

//         Queue<TreeNode> q = new LinkedList<>();
//         q.offer(root);

//         boolean odd = false;

//         while(!q.isEmpty()) {
//             int size = q.size();
//             List<Integer> curr = new ArrayList<>();

//             for(int i = 0; i < size; i++) {
//                 TreeNode node = q.poll();
//                 curr.add(node.val);

//                 if(node.left != null) q.offer(node.left);
//                 if(node.right != null) q.offer(node.right);
//             }

//             if(odd) Collections.reverse(curr);

//             res.add(curr); 

//             odd = !odd;
//         }

//         return res;
//     }
// }