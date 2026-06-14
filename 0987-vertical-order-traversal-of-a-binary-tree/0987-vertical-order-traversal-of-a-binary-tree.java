/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private static class NodeInfo {
        int row;
        int col;
        int val;

        NodeInfo(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<NodeInfo> nodes = new ArrayList<>();
        inorder(root, 0, 0, nodes);
        Collections.sort(nodes, (a, b) -> {
            if (a.col != b.col) {
                return Integer.compare(a.col, b.col); 
            }
            if (a.row != b.row) {
                return Integer.compare(a.row, b.row); 
            }
            return Integer.compare(a.val, b.val);     
        });

        List<List<Integer>> result = new ArrayList<>();
        if (nodes.isEmpty()) {
            return result;
        }

        int currentCol = nodes.get(0).col;
        List<Integer> currentColumnList = new ArrayList<>();

        for (NodeInfo node : nodes) {
            if (node.col != currentCol) {
                result.add(currentColumnList);
                currentColumnList = new ArrayList<>();
                currentCol = node.col;
            }
            currentColumnList.add(node.val);
        }
        result.add(currentColumnList); 

        return result;
    } // Fixed: Removed the duplicate closing brace that was right below this line

    private void inorder(TreeNode node, int row, int col, List<NodeInfo> nodes) {
        if (node == null) {
            return;
        }
        inorder(node.left, row + 1, col - 1, nodes);
        nodes.add(new NodeInfo(row, col, node.val));
        inorder(node.right, row + 1, col + 1, nodes);
    }
}