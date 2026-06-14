class Solution {
    private List<List<Integer>> res;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        res = new ArrayList<>();
        helper(root, sum, new ArrayList<>());
        return res;
    }

    private void helper(TreeNode root, int sum, List<Integer> curr) {
        if(root == null) return;

        curr.add(root.val);
        if(root.left == null && root.right == null) {
            if(root.val == sum) {
                res.add(new ArrayList<>(curr));
            }
        }

        helper(root.left,  sum - root.val, curr);
        helper(root.right, sum - root.val, curr);
        curr.removeLast();
    }
}