class Solution {
    public TreeNode buildTree(int[] pre, int[] in) {
        int n = pre.length;
        if(n == 0) return null;

        int r = pre[0];
        int idx = 0;

        for(int i = 0; i < n; i++) {
            if(r == in[i]) idx = i;
        }

        TreeNode node = new TreeNode(r);

        node.left = buildTree(Arrays.copyOfRange(pre, 1, idx+1), Arrays.copyOfRange(in, 0, idx));

        node.right = buildTree(Arrays.copyOfRange(pre, idx+1, n), Arrays.copyOfRange(in, idx+1, n));

        return node;
    }
}