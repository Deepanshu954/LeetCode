class Solution {
    private List<Integer> res;
    public List<Integer> postorderTraversal(TreeNode root) {
        res = new ArrayList<>();

        helper(root);
        return res;
    }

    private void helper(TreeNode root) {
        if(root == null) return;

        helper(root.left);
        helper(root.right);
        res.add(root.val);
    }
}