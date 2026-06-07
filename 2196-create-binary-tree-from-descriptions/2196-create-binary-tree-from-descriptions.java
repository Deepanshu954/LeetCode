class Solution {
    public TreeNode createBinaryTree(int[][] des) {
        int n = des.length;

        Map<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> hasParent = new HashSet<>();

        for (int i = 0; i < n; i++) {
            if (!map.containsKey(des[i][0])) {
                map.put(des[i][0], new TreeNode(des[i][0]));
            }
            if (!map.containsKey(des[i][1])) {
                map.put(des[i][1], new TreeNode(des[i][1]));
            }

            hasParent.add(des[i][1]);
        }

        TreeNode root = null;
        for (int i = 0; i < n; i++) {
            if (des[i][2] == 1) {
                map.get(des[i][0]).left = map.get(des[i][1]); // left
            } else {
                map.get(des[i][0]).right = map.get(des[i][1]); // right
            }
            
            if (!hasParent.contains(des[i][0]))
                root = map.get(des[i][0]);
        }

        return root;
    }
}