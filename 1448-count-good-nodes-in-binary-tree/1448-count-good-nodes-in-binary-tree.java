class Solution {
    int cnt = 0;

    public int goodNodes(TreeNode root) {
        if (root == null) return 0;
        dfs(root, root.val);
        return cnt;
    }

    private void dfs(TreeNode node, int maxSoFar) {
        if (node == null) return;

        if (node.val >= maxSoFar) {
            cnt++;
            maxSoFar = node.val;
        }

        dfs(node.left, maxSoFar);
        dfs(node.right, maxSoFar);
    }
}