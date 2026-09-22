class Solution {
    class TreeInfo {
        TreeNode node;
        int idx;

        public TreeInfo(TreeNode node, int idx) {
            this.node = node;
            this.idx = idx;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        int res = 0;

        Queue<TreeInfo> q = new LinkedList<>();
        q.offer(new TreeInfo(root, 0));

        while(!q.isEmpty()) {
            int size = q.size();

            int firstIdx = q.peek().idx;
            int lastIdx = 0;

            for(int i = 0; i < size; i++) {
                TreeInfo curr = q.poll();

                TreeNode node = curr.node;
                int idx = curr.idx;

                lastIdx = idx;

                if(node.left != null) {
                    q.offer(new TreeInfo(node.left, 2*idx + 1));
                }

                if(node.right != null) {
                    q.offer(new TreeInfo(node.right, 2*idx + 2));
                }
            }

            res = Math.max(res, lastIdx - firstIdx + 1);
        }

        return res;
    }
}