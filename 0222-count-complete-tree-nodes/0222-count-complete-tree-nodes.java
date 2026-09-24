/**
 
    Inorder traversal
    or find the height of the tree..

 */
class Solution {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;

        int left = getLeftHeight(root);
        int right = getRightHeight(root);

        if(left == right) return ((1 << left) - 1);

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private int getLeftHeight(TreeNode node) {
        int height = 0;

        while(node != null) {
            node = node.left;
            height++;
        }

        return height;
    }

    private int getRightHeight(TreeNode node) {
        int height = 0;

        while(node != null) {
            node = node.right;
            height++;
        }

        return height;
    }
}