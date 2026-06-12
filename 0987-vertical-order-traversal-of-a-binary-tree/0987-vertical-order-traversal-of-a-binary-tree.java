class Solution {
    private List<List<Integer>> res;
    private TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map;

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        res = new ArrayList<>();
        map = new TreeMap<>();

        helper(root, 0, 0);

        for(TreeMap<Integer, PriorityQueue<Integer>> row : map.values()) {
            List<Integer> list = new ArrayList<>();

            for(PriorityQueue<Integer> pq : row.values()) {
                while(!pq.isEmpty()) {
                    list.add(pq.poll());
                }
            }

            res.add(list);
        }
        
        return res;
    }

    private void helper(TreeNode root, int row, int col) {
        if(root == null) return;

        map.putIfAbsent(col, new TreeMap<>());
        map.get(col).putIfAbsent(row, new PriorityQueue<>());
        map.get(col).get(row).offer(root.val);

        helper(root.left,  row+1, col-1);
        helper(root.right, row+1, col+1);
    }
}