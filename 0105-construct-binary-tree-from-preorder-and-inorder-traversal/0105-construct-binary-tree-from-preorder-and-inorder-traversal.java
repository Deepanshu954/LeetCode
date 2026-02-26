class Solution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;

        int rootVal = preorder[0];
        int index = 0;

        // Find root in inorder
        for (int i = 0; i < inorder.length; i++) {
            if (rootVal == inorder[i]) {
                index = i;
                break;
            }
        }

        TreeNode root = new TreeNode(rootVal);

        // Build left subtree
        root.left = buildTree(
                Arrays.copyOfRange(preorder, 1, index + 1),
                Arrays.copyOfRange(inorder, 0, index)
        );

        // Build right subtree
        root.right = buildTree(
                Arrays.copyOfRange(preorder, index + 1, preorder.length),
                Arrays.copyOfRange(inorder, index + 1, inorder.length)
        );

        return root;
    }
}