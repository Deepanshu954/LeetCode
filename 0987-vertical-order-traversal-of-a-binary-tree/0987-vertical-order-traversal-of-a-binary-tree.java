class Tuple {
    TreeNode node;
    int x;
    int y;

    public Tuple(TreeNode node, int x, int y) {
        this.node = node;
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        Queue<Tuple> dq = new ArrayDeque<>();
        dq.offer(new Tuple(root, 0, 0));

        while(!dq.isEmpty()) {
            Tuple t = dq.poll();

            TreeNode node = t.node;
            int x = t.x;
            int y = t.y;

            map.putIfAbsent(x, new TreeMap<>());
            map.get(x).putIfAbsent(y, new PriorityQueue<>());
            map.get(x).get(y).offer(node.val);

            if(node.left != null) {
                dq.offer(new Tuple(node.left, x-1, y+1));
            }
            if(node.right != null) {
                dq.offer(new Tuple(node.right, x+1, y+1));
            }
        }

        List<List<Integer>> res = new ArrayList<>();

        for(TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()) {
            List<Integer> col = new ArrayList<>();

            for(PriorityQueue<Integer> pq : ys.values()) {
                while(!pq.isEmpty()) {
                    col.add(pq.poll());
                }
            }

            res.add(col);
        }

        return res;
    }
}