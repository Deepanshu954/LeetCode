class Solution {
    int cnt = 0;

    public int goodNodes(TreeNode root) {
        if(root == null) return 0;
        dfs(root, root.val);
        return cnt;
    }

    private void dfs(TreeNode node, int max) {
        if(node == null) return;

        if(node.val >= max) {
            cnt++;
            max = node.val;
        }

        dfs(node.left, max);
        dfs(node.right, max);
    }
}

