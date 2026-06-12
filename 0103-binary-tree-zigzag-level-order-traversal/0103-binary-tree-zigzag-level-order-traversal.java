class Solution {
    private List<List<Integer>> res;

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        res = new ArrayList<>();
        if(root == null) return res;

        helper(root);
        return res;
    }

    private void helper(TreeNode root) {
        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.addLast(root);

        boolean flag = true;

        while(!dq.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = dq.size();

            for(int i = 0; i < size; i++) {
                TreeNode curr = dq.removeFirst();
                list.add(curr.val);

                if(curr.left != null) dq.addLast(curr.left);
                if(curr.right != null) dq.addLast(curr.right);
            }


            if(!flag) {
                Collections.reverse(list);
            }

            res.add(list);

            flag = !flag;
        }
    }
}