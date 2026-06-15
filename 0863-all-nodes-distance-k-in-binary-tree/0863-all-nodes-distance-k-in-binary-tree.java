/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Create a point from child to parent
// Traet it as graph
// Use Bfs on graph

class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> map = new HashMap<>();
        buildParent(root, null, map);

        List<Integer> list = new ArrayList<>();

        Deque<TreeNode> dq = new ArrayDeque<>();
        Set<TreeNode> vis = new HashSet<>();

        dq.offer(target);
        vis.add(target);

        int level = 0;
        while(!dq.isEmpty()) {
            int size = dq.size();

            for(int i = 0; i < size; i++) {
                TreeNode curr = dq.poll();
                vis.add(curr);
                if(level == k) list.add(curr.val);

                if(curr.left != null && !vis.contains(curr.left)) dq.offer(curr.left);
                if(curr.right != null && !vis.contains(curr.right)) dq.offer(curr.right);
                if(map.get(curr) != null) {
                    if(!vis.contains(map.get(curr))) {
                        dq.offer(map.get(curr));
                    }
                }

            }

            level++;
            if(level > k) return list;

        }

        return list;
    }

    private void buildParent(TreeNode node, TreeNode par, Map<TreeNode, TreeNode> map) {
        if(node == null) return;

        map.put(node, par);
        buildParent(node.left, node, map);
        buildParent(node.right, node, map);
    }
}