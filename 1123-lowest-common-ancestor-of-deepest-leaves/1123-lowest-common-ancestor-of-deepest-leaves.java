class Solution {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        int height = height(root);

        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.offer(root);

        int cnt = 0;
        while(!dq.isEmpty() && cnt < (height - 2)) {
            int size = dq.size();

            for(int i = 0; i < size; i++) {
                TreeNode curr = dq.poll();

                if(curr.left != null) dq.offer(curr.left);
                if(curr.right != null) dq.offer(curr.right);

            }
            cnt++;
        }

        while(!dq.isEmpty()) {
            TreeNode curr = dq.poll();

            if(curr.left != null && curr.right != null) return curr;
            if(curr.left == null && curr.right != null) return curr.right;
            if(curr.left != null && curr.right == null) return curr.left;
        }

        return root;
    }

    private int height(TreeNode root) {
        if(root == null) return 0;

        return 1 + Math.max(height(root.left), height(root.right));
    }
}

