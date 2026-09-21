class Solution {

    class TreeInfo {
        TreeNode node;
        int row;
        int col;

        public TreeInfo(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;

        TreeMap<Integer, List<int[]>> map = new TreeMap<>();
        Queue<TreeInfo> q = new LinkedList<>();
        q.offer(new TreeInfo(root, 0, 0));

        while(!q.isEmpty()) {
            TreeInfo curr = q.poll();

            TreeNode node = curr.node;
            int row = curr.row;
            int col = curr.col;

            map.computeIfAbsent(col, k -> new ArrayList<>()).add(new int[] {row, node.val});

            // left
            if(node.left != null) {
                q.offer(new TreeInfo(node.left, row + 1, col - 1));
            }


            // right
            if(node.right != null) {
                q.offer(new TreeInfo(node.right, row + 1, col + 1));
            }
        }

        for(List<int[]> nodes : map.values()) {
            nodes.sort(
                (a,b) -> (( a[0] == b[0] ) ? a[1] - b[1] : a[0] - b[0])
            );

            List<Integer> columnValues = new ArrayList<>();
            for(int[] node : nodes) {
                columnValues.add(node[1]);
            }

            res.add(columnValues);
        }


        return res;
    }
}