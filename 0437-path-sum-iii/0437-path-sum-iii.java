class Solution {
    private HashMap<Long, Integer> map;

    public int pathSum(TreeNode root, int sum) {
        map = new HashMap<>();
        map.put(0L, 1);
        return dfs(root, 0, sum);
    }

    private int dfs(TreeNode node, long currSum, int target) {
        if(node == null) return 0;

        currSum += node.val;

        int cnt = map.getOrDefault(currSum - target, 0);
        map.put(currSum, map.getOrDefault(currSum, 0) + 1);

        cnt += dfs(node.left, currSum, target);
        cnt += dfs(node.right, currSum, target);

        map.put(currSum, map.get(currSum) - 1);

        return cnt;
    }
}