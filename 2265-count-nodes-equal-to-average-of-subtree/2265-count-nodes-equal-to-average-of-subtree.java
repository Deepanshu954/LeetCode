class Solution {
    public int averageOfSubtree(TreeNode root) {
        int[] res = new int[1];
        dfs(root, res);
        return res[0];
    }

    private int[] dfs(TreeNode node, int[] res) {
        if(node == null) return new int[] {0, 0};

        int[] left = dfs(node.left, res);
        int[] right = dfs(node.right, res);

        int currSum = node.val + left[0] + right[0];
        int currCnt = 1 + left[1] + right[1];

        if(currSum / currCnt == node.val) res[0]++;

        return new int[] {currSum, currCnt}; 
    }
}