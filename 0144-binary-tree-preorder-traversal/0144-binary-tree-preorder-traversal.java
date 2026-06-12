class Solution {
    private List<Integer> res;
    public List<Integer> preorderTraversal(TreeNode root) {
        res = new ArrayList<>();

        helper(root);
        return res;
    }

    private void helper(TreeNode root) {
        if(root == null) return;

        res.add(root.val);
        helper(root.left);
        helper(root.right);
    }
}