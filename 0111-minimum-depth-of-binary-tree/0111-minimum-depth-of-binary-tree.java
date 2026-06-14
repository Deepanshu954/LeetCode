class Solution {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;

        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.offer(root);

        int cnt = 1;
        while(!dq.isEmpty()) {
            int size = dq.size();

            for(int i = 0; i < size; i++) {
                TreeNode curr = dq.poll();

                if(curr.left == null && curr.right == null) return cnt;
                if(curr.left != null) dq.offer(curr.left);
                if(curr.right != null) dq.offer(curr.right);
            }

            cnt++;
        }

        return cnt;
    }
}