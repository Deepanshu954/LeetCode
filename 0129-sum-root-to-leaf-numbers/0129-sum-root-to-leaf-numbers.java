class Solution {
    private List<Integer> list;
    public int sumNumbers(TreeNode root) {
        list = new ArrayList<>();

        helper(root, 0);

        int res = 0;
        for(int l : list) {
            res += l;
        }
        return res/2;
    }

    private void helper(TreeNode root, int num) {
        if(root == null) {
            list.add(num);
            return;
        }

        num = (10 * num) + root.val;
        helper(root.left, num);
        helper(root.right, num);
        num = num / 10;

    }
}